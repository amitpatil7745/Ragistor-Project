package com.example.sampleproject.service;

import com.example.sampleproject.model.Course;
import com.example.sampleproject.model.Employee;

public interface EmployeeService {
	
	public Employee registerEmployee(Employee employee);
	
	public Employee findByEmail(String email);
	
	public Employee findByEmailAndPassword(String email, String password);
	
	public Employee findByToken(String token);






}