package com.practice.multipoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("com.multi.multi-core")
@SpringBootApplication(scanBasePackages = { "com.multi" })
public class MultiPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiPointApplication.class, args);
	}

}
