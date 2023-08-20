package com.practice.multicard.payment.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multicard.payment.dto.CardPaymentDto;
import com.practice.multicard.payment.service.CardPaymentFactory;
import com.practice.multicard.payment.service.CardPaymentService;

@RestController
public class PamentController {

    private CardPaymentService cardPaymentService;

    private CardPaymentFactory cardPaymentFactory;

    public PamentController(CardPaymentService cardPaymentService) {
        this.cardPaymentService = cardPaymentService;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public void pay(@RequestBody CardPaymentDto.PaymentRequest req) {
        cardPaymentService = cardPaymentFactory.getType(req.getType());
        cardPaymentService.pay(req);
    }

}
