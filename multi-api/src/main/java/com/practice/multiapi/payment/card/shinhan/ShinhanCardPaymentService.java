package com.practice.multicard.card.shinhan;

import org.springframework.stereotype.Service;

import com.practice.multicard.payment.dto.CardPaymentDto.PaymentRequest;
import com.practice.multicard.payment.service.CardPaymentService;

@Service
public class ShinhanCardPaymentService implements CardPaymentService {

    private ShinhanCardApi shinhanCardApi;

    public ShinhanCardPaymentService(ShinhanCardApi shinhanCardApi) {
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
