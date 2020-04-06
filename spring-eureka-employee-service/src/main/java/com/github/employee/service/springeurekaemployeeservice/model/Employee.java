package com.github.employee.service.springeurekaemployeeservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	private String first_Name;
	private String last_Name;
	private String address;

	public Employee() {

	}

	public Employee(Integer id, String first_Name, String last_Name, String address) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.address = address;
	}

	
	public Integer getId() {
		return id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", address=" + address
				+ "]";
	}


}
