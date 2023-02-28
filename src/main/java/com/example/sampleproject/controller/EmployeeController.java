package com.example.sampleproject.controller;

import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampleproject.model.Employee;
import com.example.sampleproject.service.EmployeeService;

@RestController
public class EmployeeController {

	private static final SecureRandom secureRandom = new SecureRandom(); // threadsafe
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); // threadsafe

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("registeremployee")//save
	public ResponseEntity<?> registerEmployee(@RequestBody Employee employee){
		String tempEmail = employee.getEmail();
		if (tempEmail != null && !"".equals(tempEmail)) {
			Employee employeeobj = employeeservice.findByEmail(tempEmail);
			if (employeeobj != null) {
				return ResponseEntity.ok("Email already exist!!");
				
			}
		}
		Employee employeeObj = null;
		employeeservice.registerEmployee(employee);
		return ResponseEntity.ok(employeeObj);
	}

	@PostMapping("login")
	public ResponseEntity<?> loginEmployee(@RequestBody Employee employee) throws Exception {
		String tempEmail = employee.getEmail();
		String tempPassword = employee.getPassword();
		Employee employeeObj = null;
		if (tempEmail != null && tempPassword != null) {
			employeeObj = employeeservice.findByEmailAndPassword(tempEmail, tempPassword);
		}
		if (employeeObj == null) {
			
			return ResponseEntity.ok("Invalid user details!!");
		}
		employeeObj.setToken(generateNewToken());
		employeeservice.registerEmployee(employeeObj);
		employeeObj.setPassword("");
		return ResponseEntity.ok(employeeObj);
		
	}

	private static String generateNewToken() {
		byte[] randomBytes = new byte[24];
		secureRandom.nextBytes(randomBytes);
		return base64Encoder.encodeToString(randomBytes);
	}
	

}
