package com.gn.restapi.restservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gn.restapi.restservice.service.StudentService;
import com.gn.restapi.restservice.service.StudentServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean(name = "studentService")
	public StudentService getStudentService( ) {
		StudentService studentService = new StudentServiceImpl();
		return studentService;
	}

}
