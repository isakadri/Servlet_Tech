package com.is.controller;



import com.is.entity.StudentEntity;
import com.is.service.Student_Service;

public class StudentController {
	public static void main(String[] args) {
		
		
		
		
		
		Student_Service service=new Student_Service();	
		StudentEntity se=new StudentEntity();
		
		
		String res=service.insert(se);
		System.out.println(res);
		
		
		StudentEntity std=service.updateStd(1, se);
		System.out.println(std);
		
		
		
		
		
		
	}
}
