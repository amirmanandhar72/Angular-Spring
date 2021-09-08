package com.angular.spring.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.spring.exception.ResourceNotFoundException;
import com.angular.spring.model.Employee;
import com.angular.spring.repository.EmployeeRepository;
import com.angular.spring.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	@Override
	public Employee getById(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Not found"+id));
		return employee;
	}
	@Override
	public Employee update(long id,Employee employee) {
		Employee existingemployee=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("herllo"+id));
		
		existingemployee.setEmail(employee.getEmail());
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		employeeRepository.save(existingemployee);
		return existingemployee;
	}
	@Override
	public Employee create(Employee employee) {
			
		return employeeRepository.save(employee);
	}
	@Override
	public void destroy(long id) {
		employeeRepository.deleteById(id);
		
	}
	
	
	
	

}
