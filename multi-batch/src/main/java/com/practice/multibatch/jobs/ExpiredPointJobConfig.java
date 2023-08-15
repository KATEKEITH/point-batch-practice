package com.practice.multibatch.jobs;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.multibatch.entity.Point;
import com.practice.multibatch.repository.PointRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class ExpiredPointJobConfig {

    private static final String JOB_NAME = "expiredPointJob";
    private static final String BEAN_PREFIX = JOB_NAME + "_";

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final PointRepository pointRepository;

    private int chunkSize = 10;

    @Qualifier(BEAN_PREFIX + "eventJobParameter")
    private final EventJobParameter eventJobParameter;

    @Bean(JOB_NAME)
    public Job expiredPointJob() {
        return jobBuilderFactory.get(JOB_NAME)
                .preventRestart()
                .start(expiredJobStep())
                .build();
    }

    @Bean(BEAN_PREFIX + "step")
    public Step expiredJobStep() {
        return stepBuilderFactory.get(BEAN_PREFIX + "step")
                .<Point, Point>chunk(chunkSize)
                .reader(expiredPointReader())
                .processor(expiredPointProcessor())
                .writer(expiredPointWriter())
                .build();
    }

    @Bean
    @StepScope
    public JpaPagingItemReader<Point> expiredPointReader() {
        List<Point> points = pointRepository.findAll();

        return new JpaPagingItemReader<>(points);
    }

    public ItemProcessor<Point, Point> expiredPointProcessor() {
        return new org.springframework.batch.item.ItemProcessor<Point, Point>() {
            @Override
            public Point process(Point point) throws Exception {
                return point.setInactive();
            }
        };
    }

    public ItemWriter<Point> expiredPointWriter() {
        return ((List<? extends Point> points) -> pointRepository.saveAll(points));
    }

}
