package com.joseph.beer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class BeerApplication {

	public static void main(String[] args) {

		SpringApplication.run(BeerApplication.class, args);
	}
}
