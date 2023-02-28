package com.example.sampleproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sampleproject.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
