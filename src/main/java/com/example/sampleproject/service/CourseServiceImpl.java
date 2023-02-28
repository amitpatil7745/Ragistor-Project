package com.example.sampleproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampleproject.dao.CourseRepository;
import com.example.sampleproject.model.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course addCourse(Course course) {
		
		return courseRepository.save(course);
	}

	@Override
	public void deleteById(Integer courseId) {
		
		courseRepository.deleteById(courseId);
		
	}

	@Override
	public List<Course> getAllCourse() {
		
		return courseRepository.findAll();
	}
	

	
}
