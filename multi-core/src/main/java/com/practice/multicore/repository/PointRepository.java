package com.practice.multicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.multicore.entity.Point;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

}
