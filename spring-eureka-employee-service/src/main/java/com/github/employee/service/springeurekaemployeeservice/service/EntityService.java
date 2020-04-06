package com.github.employee.service.springeurekaemployeeservice.service;

import java.util.List;
import java.util.Optional;

import com.github.employee.service.springeurekaemployeeservice.model.Employee;




public interface EntityService {

	public Integer addEmployee(Employee employee) throws Exception;
	public Optional<Employee> getEmployeeById(Integer employeeId) throws Exception;
	public List<Employee> getAllEmployees() throws Exception;
	
}
