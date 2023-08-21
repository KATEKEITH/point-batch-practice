package com.practice.multiapi.payment.service;

import com.practice.multiapi.payment.dto.CardPaymentDto;

public interface OverseasPaymentService {

    void pay(CardPaymentDto.PaymentRequest req);

}
