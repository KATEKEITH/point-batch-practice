package com.practice.multicore.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    // 유저 아이디
    private String userId;

    // 상품 아이디
    private Long productId;

    // 상태
    @Enumerated(EnumType.STRING)
    private Status status;

    @Setter
    @ColumnDefault("0")
    private String amount;

    // 유효 기간
    @Column
    private LocalDateTime expireDate;

    @Getter
    @RequiredArgsConstructor
    public enum Status {
        ACTIVE("활성화"), INACTIVE("비화성화");

        private final String description;
    }

    @Builder
    public Point(String userId, Long productId, String amount) {
        this.userId = userId;
        this.productId = productId;
        this.amount = amount;
        this.status = Status.ACTIVE;
        this.expireDate = LocalDateTime.now().plusYears(1);
    }

    public Point setInactive() {
        status = Status.INACTIVE;
        return this;
    }

}
