package com.example.sampleproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampleproject.dao.EmployeeRepository;
import com.example.sampleproject.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee registerEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee findByEmail(String email) {
		
		return employeeRepository.findByEmail(email);
	}

	@Override
	public Employee findByEmailAndPassword(String email, String password) {
		
		return employeeRepository.findByEmailAndPassword(email, password) ;
	}

	@Override
	public Employee findByToken(String token) {
		
		return employeeRepository.findByToken(token);
	}
	
	
	
	
	

}
