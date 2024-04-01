package com.example.demo;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.run.Location;
import com.example.demo.run.Run;

@SpringBootApplication
public class Application {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1, "My first run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS) ,5, Location.OUTDOOR);
			log.info("Run: {}", run);
		};
	}
}
