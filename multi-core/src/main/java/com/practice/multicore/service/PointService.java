package com.practice.multicore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.multicore.entity.Point;
import com.practice.multicore.repository.PointRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointRepository;

    public List<Point> test() {
        return pointRepository.findAll();
    }

}
