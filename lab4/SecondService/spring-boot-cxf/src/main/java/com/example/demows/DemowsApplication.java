package com.example.demows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DemowsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemowsApplication.class, args);
	}

}
