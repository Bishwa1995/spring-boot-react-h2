package com.myproject.restapi.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.restapi.model.dto.StudentDto;
import com.myproject.restapi.model.entity.Student;
import com.myproject.restapi.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository repository ;

	@Override
	public Student save(StudentDto studentDto) {
		Student st = new Student();
		BeanUtils.copyProperties(studentDto, st);
		return  repository.save(st);
	}

	@Override
	public List<Student> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public Student findById(Integer id) {
		return repository.findById(id).get();
	}

	@Override
	public void update(StudentDto studentDto) throws Exception {
		if(null == studentDto) {
			throw new Exception("Student info can not be null");
		}
		repository.setStudentInfoById(studentDto.getName(), studentDto.getAge(), studentDto.getStandard(), studentDto.getId());
	}

}
