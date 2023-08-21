package com.practice.multiapi.payment.service;

import org.springframework.stereotype.Component;

import com.practice.multiapi.payment.card.CardType;
import com.practice.multiapi.payment.card.shinhan.ShinhanCardPaymentService;
import com.practice.multiapi.payment.card.woori.WooriCardPaymentService;

@Component
public class CardPaymentFactory {

    private WooriCardPaymentService wooriCardPaymentService;

    private ShinhanCardPaymentService shinhanCardPaymentService;

    public CardPaymentFactory(WooriCardPaymentService wooriCardPaymentService,
            ShinhanCardPaymentService shinhanCardPaymentService) {
        this.wooriCardPaymentService = wooriCardPaymentService;
        this.shinhanCardPaymentService = shinhanCardPaymentService;

    }

    public PaymentService getType(CardType type) {

        final PaymentService cardPaymentService;

        switch (type) {
            case WOORI:
                cardPaymentService = wooriCardPaymentService;
                break;
            case SHINHAN:
                cardPaymentService = shinhanCardPaymentService;
                break;
            default:
                throw new IllegalArgumentException();
        }

        return cardPaymentService;
    }

}
