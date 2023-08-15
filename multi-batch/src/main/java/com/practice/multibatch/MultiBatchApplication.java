package com.practice.multibatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class MultiBatchApplication {

	public static void main(String[] args) {

		SpringApplication.run(MultiBatchApplication.class, args);

		// final var context = SpringApplication.run(MultiBatchApplication.class, args);
		// System.exit(SpringApplication.exit(context));
	}

}
