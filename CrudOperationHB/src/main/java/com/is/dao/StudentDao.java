package com.is.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.is.entity.StudentEntity;

public class StudentDao {

	private static SessionFactory sessionFactory;

	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(StudentEntity.class);

		sessionFactory = cfg.buildSessionFactory();
	}

	public StudentEntity updateData(int id,StudentEntity se) {

        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
        		tx=session.beginTransaction();
        		
        		String hqlString="UPDATE Student SET name=:name where id=:id";
        		
        		session.createMutationQuery(hqlString)
        				.setParameter("name", "isa")
        				.setParameter(id, id)
        				.executeUpdate();
        		
        		tx.commit();
        		
        		se.setName("isa");

        		
        		
        		
        		
        
        }catch (Exception e) {
        	System.out.println(e.getStackTrace());
		}
    	
    
    	
    	return se;
    }

	public String insert(StudentEntity se) {

		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.persist(se);

			tx.commit();

			return "Inserted Successfully";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();

			return "Insert Failed";

		} finally {
			session.close();
		}
	}
}