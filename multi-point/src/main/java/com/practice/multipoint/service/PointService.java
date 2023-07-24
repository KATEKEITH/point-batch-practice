package com.practice.multipoint.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.practice.multicore.entity.Point;
import com.practice.multicore.repository.PointRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;

    private static final int POINT_RATE = 1;

    public List<Point> test() {
        return pointRepository.findAll();
    }

    public int calculateAmount(int price) {
        return price * POINT_RATE / 100;
    }

}
