package com.aga;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MessageHQLFromTest {
	
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		String query = null;
		
		try {
				// config the db details
				sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
				//get the session using session factory object
				session = sf.openSession();
				tx = session.beginTransaction();
				
				session = sf.openSession();
				query = "from MessageSQL";
				Query q = session.createQuery(query);
				
				// get List from Query
				List<MessageSQL> list = q.list();
				
				// get iterator from Query
				Iterator<MessageSQL> itr = q.iterate();
				
				System.out.println("MessageID		MessageText		SenderName		SendDate");
				for(MessageSQL obj : list) {
					System.out.print(obj.getMessageId()+"		");
					System.out.print(obj.getMessageText()+"		");
					System.out.print(obj.getSenderName()+"		");
					System.out.print(obj.getSendDate()+"		");
					
					System.out.println();
				}
				
				// show using iterator
				while(itr.hasNext()) {
					MessageSQL obj = itr.next();
					System.out.print(obj.getMessageId()+"		");
					System.out.print(obj.getMessageText()+"		");
					System.out.print(obj.getSenderName()+"		");
					System.out.print(obj.getSendDate()+"		");
					System.out.println();
				}
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}