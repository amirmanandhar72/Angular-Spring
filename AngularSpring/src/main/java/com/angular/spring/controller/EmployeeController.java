package com.angular.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.spring.model.Employee;

import com.angular.spring.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> employeeList() {
		return employeeService.getAllEmployees();
		
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable long id) {
		Employee employee=employeeService.getById(id);
		return employee;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee>  updateEmployee(@PathVariable long id ,@RequestBody Employee employee) {
		 return new ResponseEntity<Employee>(employeeService.update(id, employee),HttpStatus.OK);
	}
	@PostMapping("/employees")
	public ResponseEntity<Employee> create(@RequestBody Employee emplyee){
		
		return new ResponseEntity<Employee>(employeeService.create(emplyee),HttpStatus.OK);
		
	}
	@DeleteMapping("/employees/{id}")
	public void destroy(@PathVariable long id ) {
		employeeService.destroy(id);
	}
	

}
