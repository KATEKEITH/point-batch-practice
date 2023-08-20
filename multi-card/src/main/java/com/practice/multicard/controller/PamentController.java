package com.practice.multicard.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multicard.CardPaymentDto;
import com.practice.multicard.CardType;
import com.practice.multicard.service.ShinhanCardPaymentService;
import com.practice.multicard.service.WooriCardPaymentService;

@RestController
public class PamentController {

    private ShinhanCardPaymentService shinhanCardPaymentService;

    private WooriCardPaymentService wooriCardPaymentService;

    public PamentController(ShinhanCardPaymentService shinhanCardPaymentService,
            WooriCardPaymentService wooriCardPaymentService) {
        this.shinhanCardPaymentService = shinhanCardPaymentService;
        this.wooriCardPaymentService = wooriCardPaymentService;
    }

    @RequestMapping(value = "/ocp/anti/payment", method = RequestMethod.POST)
    public void pay(@RequestBody CardPaymentDto.PaymentRequest req) {
        if (req.getType() == CardType.SHINHAN) {
            shinhanCardPaymentService.pay(req);
        } else if (req.getType() == CardType.WOORI) {
            wooriCardPaymentService.pay(req);
        }
    }

}
