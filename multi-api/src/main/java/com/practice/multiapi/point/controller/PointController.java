package com.practice.multipoint.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multicore.entity.Point;
import com.practice.multipoint.service.PointService;

@RestController
public class PointController {

    private final PointService pointService;

    private final ApplicationContext applicationContext;

    public PointController(PointService pointService, ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.pointService = pointService;
    }

    @GetMapping("/test")
    public List<Point> test() {
        return pointService.test();
    }

    @GetMapping("/bean")
    @ResponseBody
    public String bean() {
        return "bean >>>>>>> " + applicationContext.getBean(PointService.class) + "\n"
                + "points: " + this.pointService;
    }

}
