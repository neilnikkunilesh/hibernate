package com.aga.database;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class SessionObject {
	public static Session getSession() {
		SessionFactory sf = null;
		Session session = null;
		try {
			System.out.println("Inside Session Created");
			sf	=	new	AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
				session = (Session) sf.openSession();
				System.out.println("session create sucessfully");
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		
		return session;
		
	}
}
