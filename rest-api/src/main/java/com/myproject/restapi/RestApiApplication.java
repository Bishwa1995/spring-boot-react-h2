package com.myproject.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myproject.restapi.model.dto.StudentDto;
import com.myproject.restapi.service.StudentService;

@SpringBootApplication
public class RestApiApplication implements CommandLineRunner{
	
	@Autowired
	StudentService service;

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		StudentDto student1 = new StudentDto();
		student1.setName("Bishwa");
		student1.setAge(8);
		student1.setStandard("3");
		
		service.save(student1);
		
	}

}
