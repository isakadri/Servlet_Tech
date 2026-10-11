package com.isa;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class MainClass {
// DB Connection 

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction t = ss.beginTransaction();

		
		  Student s = new Student(); 
		  s.setId(124l); 
		  s.setAge(15); 
		  s.setName("suraj");
		  s.setCity("pune");
		  
//		  ss.persist(s);
		  
		  s.setAge(24);
		  
		  Student upstd=ss.merge(s);
		  
		 
		 t.commit(); ss.close();
		 System.out.println("Inserted Successfully....");
		 
		 
		 
		 
		

	/*	String hql = "UPDATE Student SET name =: name WHERE id =: id";

		MutationQuery query = ss.createMutationQuery(hql);
		query.setParameter("id", 124);
		query.setParameter("name", "rahul");
		query.executeUpdate();

		t.commit();
		ss.close();  
		System.out.println("updated Successfully....");
		  */
		
		/* String hql="DELETE Student where id =: id";
		MutationQuery query= ss.createMutationQuery(hql);
		query.setParameter("id", 124);
		
		query.executeUpdate();
		
		
		t.commit();
		ss.close();
		
		System.out.println("deleted Successfully....");
		 */
		
		

		/*String hql="FROM Student";
		List<Student> list=ss.createQuery(hql).getResultList();
		
		for (Student student : list) {
			System.out.println(student.getId()+" "+student.getName()+" "+student.getAge()+" "+student.getCity());
		}*/

	}
}
