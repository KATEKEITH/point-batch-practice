package com.practice.multiapi.payment.card.woori;

import org.springframework.stereotype.Service;

import com.practice.multiapi.payment.dto.CardPaymentDto.PaymentRequest;
import com.practice.multiapi.payment.service.PaymentService;

@Service
public class WooriCardPaymentService implements PaymentService {

    private WooriCardApi wooriCardApi;

    public WooriCardPaymentService(WooriCardApi wooriCardApi) {
        this.wooriCardApi = wooriCardApi;
    }

    @Override
    public void pay(PaymentRequest req) {
        final WooriCardDto.PaymentRequest paymentRequest = WooriCardDto.PaymentRequest.builder()
                .number(req.getCardNumber())
                .CVS(req.getCsv())
                .build();
        wooriCardApi.pay(paymentRequest);
    }

}
