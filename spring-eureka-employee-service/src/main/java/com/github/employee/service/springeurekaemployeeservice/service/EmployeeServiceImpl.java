package com.github.employee.service.springeurekaemployeeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.employee.service.springeurekaemployeeservice.model.Employee;
import com.github.employee.service.springeurekaemployeeservice.repository.EmployeeRepository;

@Service("employeeService")
public class EmployeeServiceImpl extends EntityServiceImpl{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository repository;
	public Integer addEmployee(Employee employee) throws Exception{
		
	        log.info("Saving Employee details in the database.");
	        repository.save(employee);
	        return employee.getId();
	    
	}
	
    // Get all Employees from the h2 database.
    public List<Employee> getAllEmployees() {
        final List<Employee> employees = new ArrayList<>();
        repository.findAll().forEach(employee -> employees.add(employee));
        return employees;
    }
    
    // Get Particular Employee By Id from the h2 database.
    public Optional<Employee> getEmployeeById(Integer id) {
     
        return repository.findById(id);
    }
}
