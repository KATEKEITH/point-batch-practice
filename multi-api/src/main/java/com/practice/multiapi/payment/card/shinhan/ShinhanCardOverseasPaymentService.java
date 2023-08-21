package com.practice.multiapi.payment.card.shinhan;

import org.springframework.stereotype.Service;

import com.practice.multiapi.payment.dto.CardPaymentDto.PaymentRequest;
import com.practice.multiapi.payment.service.OverseasPaymentService;

@Service
public class ShinhanCardOverseasPaymentService implements OverseasPaymentService {

    private ShinhanCardApi shinhanCardApi;

    public ShinhanCardOverseasPaymentService(ShinhanCardApi shinhanCardApi) {
        this.shinhanCardApi = shinhanCardApi;
    }

    @Override
    public void pay(PaymentRequest req) {
        final ShinhanCardDto.PaymentRequest paymentRequest = ShinhanCardDto.PaymentRequest.builder()
                .shinhanCardNumber(req.getCardNumber())
                .cvc(req.getCsv())
                .build();
        shinhanCardApi.pay(paymentRequest);
    }

}
