package com.aga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MessageTest {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		/* if you have configuration file name other than default
		 * 'hibernate.cfg.xml' that should be specified in the
		 * configure method else its not required
		*/	
		
		// building SessionFactory object
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		//sessionFactory = new Configuration().configure().buildSessionFactory();
		
		//Obtaining a session
		Session session = sessionFactory.openSession();
		
		//Beginning a transaction
		Transaction transaction = session.beginTransaction();
		
		// Insert Message in Database
		Message message = new Message();
		message.setMessageId(34);
		message.setMessageText("Hello World of Hibernte Example XMLMapping with MySql");
		
		Integer id = (Integer)session.save(message);// persisting the object
		transaction.commit();
		
		// to get the added Records from Database
		
		// get the SessionFactory object reference
		session = sessionFactory.openSession();
		Message msgFind = (Message)session.get(Message.class, id);
		System.out.println("Added Message is: "+ msgFind.getMessageText());
		
	}
}
