package com.practice.multibatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.multicore.entity.Point;

public interface PointRepository extends JpaRepository<Point, Long> {

    // @Query("SELECT p FROM Point p WHERE p.status = 'ACTIVE' AND p.expireDate >=
    // DATE_ADD(NOW(), INTERVAL 2 DAY)")
    // List<Point> findALLPoints();

}
