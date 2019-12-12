package com.gn.restapi.restservice.service;

import java.util.ArrayList;
import java.util.List;

import com.gn.restapi.restservice.model.Course;

public class StudentServiceImpl implements StudentService{

	@Override
	public List<Course> retrieveCourses(String studentId) {
		System.out.println("Calling student service");
		System.out.println("Retrieving all courses of student id : "+ studentId);
		List<Course> courses = new ArrayList<>();
		courses.add(new Course(studentId, "stn1", "Example", new ArrayList<>()));
		
		return courses;
	}

	@Override
	public Course retrieveCourse(String studentId, String courseId) {
		// TODO Auto-generated method stub
		return null;
	}

}
