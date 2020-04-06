package com.github.employee.service.springeurekaemployeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringEurekaEmployeeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaEmployeeServiceApplication.class, args);
	}

}
