package com.practice.multibatch.jobs;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.multicore.entity.Point;
import com.practice.multicore.repository.PointRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class InactiveUserJobConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    // private final PointRepository pointRepository;

    // @Bean
    // public Job expiredPointJob() {
    // return jobBuilderFactory.get("expiredPointJob")
    // .preventRestart()
    // .start(expiredJobStep(null))
    // .build();
    // }

    // @Bean
    // public Step expiredJobStep(@Value("#{jobParameters[requestDate]}") final
    // String requestDate) {
    // log.info("requestDate: {}", requestDate);

    // return stepBuilderFactory.get("expiredJobStep")
    // .<Point, Point>chunk(10)
    // .reader(expiredPointReader())
    // .processor(expiredPointProcessor())
    // .writer(expiredPointWriter())
    // .build();
    // }

    // @Bean
    // @StepScope
    // public ListItemReader<Point> expiredPointReader() {
    // List<Point> points = pointRepository.findAll();
    // return new ListItemReader<>(points);
    // }

    // public ItemProcessor<Point, Point> expiredPointProcessor() {
    // return new org.springframework.batch.item.ItemProcessor<Point, Point>() {
    // @Override
    // public Point process(Point point) throws Exception {
    // return point.setInactive();
    // }
    // };
    // }

    // public ItemWriter<Point> expiredPointWriter() {
    // return ((List<? extends Point> points) -> pointRepository.saveAll(points));
    // }

}
