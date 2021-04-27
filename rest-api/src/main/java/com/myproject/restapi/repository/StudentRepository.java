package com.myproject.restapi.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.restapi.model.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	@Modifying
	@Transactional
	@Query("update Student s set s.name = ?1, s.age = ?2 , s.standard = ?3  where s.id = ?4")
	void setStudentInfoById(String name, int age, String standard, Integer userId);

}
