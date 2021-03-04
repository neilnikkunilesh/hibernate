package com.aga;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
			configuration.addAnnotatedClass(Employee.class);
//			sessionFactory = new Configuration().configure().buildSessionFactory();
			sessionFactory = configuration.buildSessionFactory();
		}catch(Throwable ex) {
			System.out.println("Inital SessionFactory creation failed."+ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
