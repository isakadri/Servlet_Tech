package com.is.service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.is.dao.StudentDao;
import com.is.entity.StudentEntity;

public class Student_Service {
	
	StudentDao sd=new StudentDao();
	
	
	public StudentEntity updateStd(int id,StudentEntity se) {
		return sd.updateData(id, se);
	}
	
	
	
	public String  insert(StudentEntity se) {
		
		
		se.setAge(15);
		se.setName("suraj");
		se.setCity("pune");
		return sd.insert(se);

	}
	
	
	

	
}
