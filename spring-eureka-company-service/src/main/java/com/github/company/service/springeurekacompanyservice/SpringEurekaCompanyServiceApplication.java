package com.github.company.service.springeurekacompanyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaCompanyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaCompanyServiceApplication.class, args);
	}

}
