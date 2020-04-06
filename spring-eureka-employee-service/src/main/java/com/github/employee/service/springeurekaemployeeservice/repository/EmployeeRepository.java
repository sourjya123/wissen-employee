package com.github.employee.service.springeurekaemployeeservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.github.employee.service.springeurekaemployeeservice.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	Optional<Employee> findById(Integer id);

}
