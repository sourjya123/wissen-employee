package com.github.employee.service.springeurekaemployeeservice.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.employee.service.springeurekaemployeeservice.model.Employee;
import com.github.employee.service.springeurekaemployeeservice.service.EntityService;

@RestController
public class EmployeeController {

	@Autowired
	EntityService employeeService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/wissen/employee", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity getAllEmployees() {
		System.out.println(1);
		List<Employee> allEmployees = null;
		try {
			allEmployees = employeeService.getAllEmployees();
			System.out.println(allEmployees);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity((List) allEmployees, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/wissen/employee/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity getEmployee(@PathVariable Integer employeeId) {
		System.out.println("Getting Student details for " + employeeId);

		Optional<Employee> employee = null;
		try {
			employee = employeeService.getEmployeeById(employeeId);
			System.out.println(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity(employee, HttpStatus.OK);
	}

	@PostMapping(value = "/wissen/employee/")
	public ResponseEntity<String> addEmployee(@RequestBody @Valid Employee employee) {
		System.out.println(employee);
		String employeeId = null;
		Integer httpStatusCode = null;

		try {
			employeeId = employeeService.addEmployee(employee).toString();
			if (employeeId != null)
				httpStatusCode = 201;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(httpStatusCode).header("New-Employee", employeeId).build();
	}

}
