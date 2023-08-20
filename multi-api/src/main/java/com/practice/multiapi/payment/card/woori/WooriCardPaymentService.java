package com.practice.multicard.card.woori;

import org.springframework.stereotype.Service;

import com.practice.multicard.payment.dto.CardPaymentDto.PaymentRequest;
import com.practice.multicard.payment.service.CardPaymentService;

@Service
public class WooriCardPaymentService implements CardPaymentService {

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
