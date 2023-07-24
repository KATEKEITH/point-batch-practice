package com.practice.multipoint.controller;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multicore.entity.Point;
import com.practice.multipoint.service.PointService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@PropertySource({ "classpath:application.yml" })
public class PointController {

    private final PointService pointService;

    @GetMapping("/test")
    public List<Point> test() {
        return pointService.test();
    }

}
