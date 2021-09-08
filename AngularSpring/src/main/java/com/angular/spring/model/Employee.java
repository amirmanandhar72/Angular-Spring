package com.angular.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="firstName",nullable = false)
	private String firstName;
	@Column(name="lastName",nullable = false)
	private String LastName;
	@Column(name="email",nullable = false)
	private String email;
	public long getId() {
		return id;
	}
	
	public Employee(){
		
	}
	public Employee(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
