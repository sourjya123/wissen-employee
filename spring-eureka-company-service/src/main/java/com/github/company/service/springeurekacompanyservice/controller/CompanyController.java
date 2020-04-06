package com.github.company.service.springeurekacompanyservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CompanyController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/wissen")
	public ResponseEntity getWissen() {
		System.out.println("hit");
		return ResponseEntity.status(200).build();
	}

	@GetMapping(value = "/wissen/employee/{employeeId}")
	public String getEmployees(@PathVariable Integer employeeId) {

		System.out.println("wissen called");
		String response = restTemplate.exchange("http://employee-service/wissen/employee/{employeeId}", HttpMethod.GET,
				null, new ParameterizedTypeReference<String>() {
				}, employeeId).getBody();

		return response;
	}

	@GetMapping(value = "/wissen/employee")
	public String getAllEmployees() {

		String response = restTemplate.exchange("http://employee-service/wissen/employee", HttpMethod.GET, null,
				new ParameterizedTypeReference<String>() {
				}).getBody();

		System.out.println("Response Received as " + response);

		return response;
	}

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/wissen/employee/")
	public ResponseEntity addEmployee(@RequestBody @Valid Employee employee) {

		ResponseEntity response = restTemplate.postForEntity("http://employee-service/wissen/employee/", employee,
				ResponseEntity.class);
		System.out.println("Response Received as " + response);

		return response;
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}