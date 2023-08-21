package com.practice.multiapi.payment.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multiapi.payment.dto.CardPaymentDto;
import com.practice.multiapi.payment.service.CardPaymentFactory;
import com.practice.multiapi.payment.service.PaymentService;

@RestController
public class PamentController {

    private PaymentService cardPaymentService;

    private CardPaymentFactory cardPaymentFactory;

    public PamentController(PaymentService cardPaymentService) {
        this.cardPaymentService = cardPaymentService;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public void pay(@RequestBody CardPaymentDto.PaymentRequest req) {
        cardPaymentService = cardPaymentFactory.getType(req.getType());
        cardPaymentService.pay(req);
    }

}
