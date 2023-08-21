package com.practice.multiapi.payment.card.shinhan;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ShinhanCardApi {

    private RestTemplate restTemplate;

    public void pay(ShinhanCardDto.PaymentRequest req) {
        restTemplate.postForObject("http://localhost:8080/shinhan", req, Void.class);
    }

    public void payOverseas(ShinhanCardDto.PaymentRequest req) {
        restTemplate.postForObject("http://localhost:8080/shinhan/oversea", req, Void.class);
    }

}
