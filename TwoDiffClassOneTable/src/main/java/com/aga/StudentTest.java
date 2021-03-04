package com.aga;

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
			Address add2 = new Address("202, Dadu Mandir","Hissar","Haryana", "590001");
			
			Student s1 = new Student("RAKESH KEDIA",add1);
			Student s2 = new Student("BHAWANI SINGH",add2);
			
			session.save(s1);
			session.save(s2);
			
			tx.commit();
			session.close();
			sf.close();
			
		} catch (Exception e) {
			//tx.rollback();
			e.printStackTrace();
		}
	}

}
