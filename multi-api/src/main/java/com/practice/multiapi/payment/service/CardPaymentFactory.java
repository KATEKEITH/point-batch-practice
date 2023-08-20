package com.practice.multicard.payment.service;

import org.springframework.stereotype.Component;

import com.practice.multicard.card.CardType;
import com.practice.multicard.card.shinhan.ShinhanCardPaymentService;
import com.practice.multicard.card.woori.WooriCardPaymentService;

@Component
public class CardPaymentFactory {

    private WooriCardPaymentService wooriCardPaymentService;

    private ShinhanCardPaymentService shinhanCardPaymentService;

    public CardPaymentFactory(WooriCardPaymentService wooriCardPaymentService,
            ShinhanCardPaymentService shinhanCardPaymentService) {
        this.wooriCardPaymentService = wooriCardPaymentService;
        this.shinhanCardPaymentService = shinhanCardPaymentService;

    }

    public CardPaymentService getType(CardType type) {

        final CardPaymentService cardPaymentService;

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
