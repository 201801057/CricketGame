package com.tekion.cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CricketApplication {
	public static void main(String[] args) {
		SpringApplication.run(CricketApplication.class, args);

	}
}
