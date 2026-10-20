package com.association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
		public static void main(String[] args) {
			Configuration cfg=new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Employee.class);
			cfg.addAnnotatedClass(Department.class);
			
			SessionFactory sf=cfg.buildSessionFactory();
			Session ss=sf.openSession();
			
			Transaction tx =ss.beginTransaction();
			
			
			Department d=new Department();
			d.setDeptId(3);
			d.setDeptName("DSE");
			
			ss.persist(d);
			
			Employee e=new Employee();
			e.setName("Suraj");
			e.setDepartment(d);
			
			ss.persist(e);
			
			
			//by Find Method :-
			Employee e1=ss.find(Employee.class, 1);
			System.out.println(e1);
			System.out.println("found successfully");
			
			
			
			// By get() Method:-
			Employee e2=ss.get(Employee.class, 1);
			System.out.println(e2.getDepartment());
			System.out.println("founded By Get");
		
			// by Load Method :-
			Employee e3=ss.load(Employee.class, 1);
			System.out.println(e3);
			System.out.println("founded By Load");

			
			
			
			
			
			tx.commit();
			ss.close();
			
		}
}
