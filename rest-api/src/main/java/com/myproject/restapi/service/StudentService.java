package com.myproject.restapi.service;

import java.util.List;

import com.myproject.restapi.model.dto.StudentDto;
import com.myproject.restapi.model.entity.Student;

public interface StudentService {
	
	Student save(StudentDto user);
	
    List<Student> findAll() throws Exception;
    
    void delete(Integer id) throws Exception;
    
    Student findById(Integer id) throws Exception;

    void update(StudentDto userDto) throws Exception;

}
