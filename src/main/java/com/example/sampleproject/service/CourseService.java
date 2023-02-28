package com.example.sampleproject.service;

import java.util.List;

import com.example.sampleproject.model.Course;

public interface CourseService {
	
	public Course addCourse(Course course);
	
	public void deleteById(Integer courseId);
	
	List<Course> getAllCourse();
	

}
