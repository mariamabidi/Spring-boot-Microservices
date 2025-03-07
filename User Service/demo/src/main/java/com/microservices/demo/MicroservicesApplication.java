package com.microservices.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
}
