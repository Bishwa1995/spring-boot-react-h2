package com.myproject.restapi.controller;


import com.myproject.restapi.model.dto.StudentDto;
import com.myproject.restapi.model.entity.Student;
import com.myproject.restapi.service.StudentService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> listUser() throws Exception{
    	return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) throws Exception{
    	Student st = studentService.findById(id);
    	StudentDto retSt = new StudentDto();
    	BeanUtils.copyProperties(st, retSt);
    	return new ResponseEntity<>(retSt, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto student){
    	Student st = studentService.save(student);
    	StudentDto retSt = new StudentDto();
    	BeanUtils.copyProperties(st, retSt);
    	return new ResponseEntity<>(retSt, HttpStatus.CREATED);
    	
    }
    
    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto student) throws Exception{
    	studentService.update(student);
    	return new ResponseEntity<>(HttpStatus.OK);
    } 
    
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentDto> deleteById(@PathVariable Integer id) throws Exception{
    	studentService.delete(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    } 
}
