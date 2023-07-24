package com.practice.multicore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Membership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Level level = Level.NORMAL;

    private Long userId;

    @Setter
    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer point;

    @Getter
    @RequiredArgsConstructor
    public enum Level {
        VIP(500_000),
        GOLD(500_000),
        SILVER(300_000),
        NORMAL(200_000);

        private final int nextAmount;
    }

    @Builder
    private Membership(Long memberId, int point) {
        this.userId = userId;
        this.point = point;
        this.level = Level.NORMAL;
    }

}
