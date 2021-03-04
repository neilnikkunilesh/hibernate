package com.aga;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentTest {

	public static void main(String[] args) {
		// Configure the db using xml file
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			
			Address add1 = new Address("23, Laxmi Nagar","Jaipur","Rajasthan", "302012");
			//Address add2 = new Address("202, Dadu Mandir","Hissar","Haryana", "590001");
			
			Student121 s1 = new Student121("RAKESH KEDIA", add1);
			//Student121 s2 = new Student121();
			
			session.save(s1);
			//session.save(s2);
			

			if(s1.getAddress() != null) {
				s1.getAddress().setId(s1.getStudentId());
				session.save(s1.getAddress());
			}
			
			tx.commit();
			session.close();
			sf.close();
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();
		}
	}

}
