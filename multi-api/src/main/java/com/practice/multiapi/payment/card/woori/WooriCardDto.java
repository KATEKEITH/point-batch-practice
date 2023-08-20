package com.practice.multicard.card.woori;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class WooriCardDto {

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    @ToString
    public static class PaymentRequest {
        private String number;
        private String CVS;

        @Builder
        public PaymentRequest(String number, String CVS) {
            this.number = number;
            this.CVS = CVS;
        }
    }

}
