package com.gn.restapi.restservice.service;

import java.util.List;

import com.gn.restapi.restservice.model.Course;

public interface StudentService {

	List<Course> retrieveCourses(String studentId);

	Course retrieveCourse(String studentId, String courseId);

}
