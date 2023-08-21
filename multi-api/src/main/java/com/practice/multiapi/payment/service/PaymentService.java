package com.practice.multiapi.payment.service;

import com.practice.multiapi.payment.dto.CardPaymentDto;

public interface PaymentService {

    void pay(CardPaymentDto.PaymentRequest req);

}
