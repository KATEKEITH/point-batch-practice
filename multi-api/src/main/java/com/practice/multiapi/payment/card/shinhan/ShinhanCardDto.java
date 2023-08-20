package com.practice.multicard.card.shinhan;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class ShinhanCardDto {

    @Getter
    @ToString
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PaymentRequest {
        private String shinhanCardNumber;
        private String cvc;

        @Builder
        public PaymentRequest(String shinhanCardNumber, String cvc) {
            this.shinhanCardNumber = shinhanCardNumber;
            this.cvc = cvc;
        }
    }

}
