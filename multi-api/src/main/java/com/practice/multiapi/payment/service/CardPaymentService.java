package com.practice.multicard.payment.service;

import com.practice.multicard.payment.dto.CardPaymentDto;

public interface CardPaymentService {

    void pay(CardPaymentDto.PaymentRequest req);

}
