package com.practice.multipoint.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.practice.multicore.entity.Membership;
import com.practice.multicore.repository.MembershipRepository;
import com.practice.multipoint.dto.MembershipDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {

    private final PointService ratePointService;

    private final MembershipRepository membershipRepository;

    @Transactional
    public Membership updateMembership(MembershipDto membershipDto) {

        final Membership membership = membershipRepository.findByUserId(membershipDto.getUserId())
                .orElseThrow(EntityNotFoundException::new);

        final int additionalAmount = ratePointService.calculateAmount(membershipDto.getOrderAmount());

        membership.setPoint(additionalAmount + membership.getPoint());

        return membership;
    }

}
