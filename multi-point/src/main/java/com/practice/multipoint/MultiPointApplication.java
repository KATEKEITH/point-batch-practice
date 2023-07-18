package com.practice.multipoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.practice")
public class MultiPointApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiPointApplication.class, args);
	}

}
