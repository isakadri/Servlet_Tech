package com.stdExam.stdExam.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.stdExam.stdExam.entity.Student;

import jakarta.persistence.Query;

@Repository
public class StudentRepository {

	@Autowired
	private SessionFactory factory;

	public ResponseEntity<String> insertData(Student s) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(s);
		tx.commit();
		session.close();

		return ResponseEntity.ok("inserted Successfully...");
	}

	public ResponseEntity<Student> update(Student s,int id) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Student updstd= session.find(Student.class, id);
		updstd.setCity(s.getCity());
		updstd.setCourse(s.getCourse());
		updstd.setDepartment(s.getDepartment());
		updstd.setFirstName(s.getFirstName());
		
		session.merge(updstd);
		tx.commit();
		session.close();

		return (ResponseEntity<Student>) ResponseEntity.ok(updstd);
	}
	
	public ResponseEntity<Student> getStd(int id) {
		Session ss=factory.openSession();
		Student s=ss.find(Student.class, id);
		
		if(s==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(s);
	}
	
	public List<Student> getAll() {
		Session ss=factory.openSession();
		Query q= ss.createQuery("FROM Student");
		List<Student>list =q.getResultList();

		return list;
	}
}
