package com.angular.spring.service;

import java.util.List;

import com.angular.spring.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getById(long id);
	
	Employee update(long id,Employee employee);
	
	Employee create(Employee employee);
	
	void destroy(long id);
	
	

}
