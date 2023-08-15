package com.practice.multicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.multicore.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

}
