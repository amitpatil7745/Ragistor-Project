package com.example.sampleproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampleproject.model.Course;
import com.example.sampleproject.model.Employee;
import com.example.sampleproject.service.CourseService;
import com.example.sampleproject.service.EmployeeService;


@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/savecourse")
	public ResponseEntity<?> addCourse(@RequestBody Course course, @RequestHeader Map<String, String>header){
		
		Employee employeeObj = employeeService.findByToken(header.get("token"));
		if(employeeObj != null && employeeObj.getRole().equals("admin") ) {
		Course courseObj = courseService.addCourse(course);
		
		return ResponseEntity.ok().body(courseObj);
		}
		return ResponseEntity.ok("not authorised to create the course");
	}
	
	@PostMapping("/deletecourse/{id}")
	public String deleteCourseByID(@PathVariable("id") Integer courseId) {
		
		courseService.deleteById(courseId);
		
		return "Deleted Sucessfully !!";
	}
	/*
	@PostMapping("/getallcourse")
	public ResponseEntity<?> List<Course> getAllCourse(@RequestHeader Map<String, String>header){
	//public List<Course>getAllCourse(){
		
		
		return courseService.getAllCourse();
		
	}
*/
	
	
	
	

}
		