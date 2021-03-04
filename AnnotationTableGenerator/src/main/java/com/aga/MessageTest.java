package com.aga;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class MessageTest {

	public static void main(String[] args) {
		

		AnnotationConfiguration configuration =new AnnotationConfiguration().configure("hibernate.cfg.xml");
		
		// It has been depricated.
		//Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		
		//configuration.addAnnotatedClass(Message.class);
		// we can configure annotation class also here if you
		// don't have configure it in hibenate.cfg.xml
		
		/* if you have configuration file name other than default
		 * 'hibernate.cfg.xml' that should be specified in the
		 * configure method else its not required
		*/	
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		// Insert Message in Database
		Message message1 = new Message();
		//message.setMessageId(3);
		message1.setMessageText("Adding Primary key ID using @SquenceGenerator");
		message1.setDateOfMessage(new Date());
		Integer id1 = (Integer)session.save(message1);
		
		
//		Message message2 = new Message();
//		message2.setMessageText("Adding Primary key ID using @SquenceGenerator");
//		message2.setDateOfMessage(new Date());
//		
//		Integer id2 = (Integer)session.save(message2);
		
		transaction.commit();
		
		// to get the added Records from Database
		
			// get the SessionFactory object reference
		session = sessionFactory.openSession();
		Message msgFind = (Message)session.get(Message.class, id1);
		System.out.println("Added Message is: "+ msgFind.getMessageText());
		
		// close the session
		session.close();
		sessionFactory.close();
		
	}
}
