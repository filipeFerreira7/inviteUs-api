package com.docker.learning.convidados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ConvidadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvidadosApplication.class, args);
	}

}
