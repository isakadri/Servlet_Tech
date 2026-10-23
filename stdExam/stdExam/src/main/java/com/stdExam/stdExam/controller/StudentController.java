package com.stdExam.stdExam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stdExam.stdExam.entity.Student;
import com.stdExam.stdExam.service.StudentService;

@RestController
@RequestMapping("/api/std")
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("/insert")
	public ResponseEntity<String> insertData(@RequestBody Student s) {
		return service.insertData(s);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@RequestBody Student s, @PathVariable int id) {

		return service.update(s, id);
	}

	@GetMapping("/getstd")
	public ResponseEntity<Student> getStd(@RequestParam int id) {

		return service.getStd(id);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll() {

		return service.getAll();
	}

}
