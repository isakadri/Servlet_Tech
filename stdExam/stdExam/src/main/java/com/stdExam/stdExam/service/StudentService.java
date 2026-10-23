package com.stdExam.stdExam.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stdExam.stdExam.entity.Student;
import com.stdExam.stdExam.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;
	
	public ResponseEntity<String> insertData(Student s) {

		

		return repo.insertData(s);
	}
	
	public ResponseEntity<Student> update(Student s,int id) {

		return repo.update(s, id);
	}
	
	public ResponseEntity<Student> getStd(int id) {
		
		
		return repo.getStd(id);
	}
	
	public List<Student> getAll() {

		return repo.getAll();
	}
}
