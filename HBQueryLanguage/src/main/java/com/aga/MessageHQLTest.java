package com.aga;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MessageHQLTest {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
				// config the db details
				sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
				//get the session using session factory object
				session = sf.openSession();
				tx = session.beginTransaction();
			
				MessageHQL msg1 = new MessageHQL("Happy Birthday Dear Rakesh Kedia","Bhawani Singh");
				msg1.setSendDate(new Date());
				session.save(msg1);
				
				MessageHQL msg2 = new MessageHQL("Happy Marriage Anniversary Dear Prateek Patel","Rajesh Kotil");
				msg2.setSendDate(new Date());
				session.save(msg2);
				
				MessageHQL msg3 = new MessageHQL("Happy New Year Dear!!","Kinson Black");
				msg3.setSendDate(new Date());
				session.save(msg3);
				
				// commit the transaction
				tx.commit();
				// close the session
				session.close();
				
				session = sf.openSession();
				Query query = session.getNamedQuery("findMessageBySenderName");
				query.setParameter("senderName", "Kinson Black");
				List result = query.list();
				if(result.size() > 0) {
					Iterator it = result.iterator();
					System.out.println("Message Details are show below:");
					while(it.hasNext()) {
						MessageHQL msg = (MessageHQL)it.next();
						System.out.println("MsgID: "+msg.getMessageId()+" MsgText: "+msg.getMessageText()+
								" Sender Name: "+msg.getSenderName()+" Send Date: "+msg.getSendDate());
					}
				}
				
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}
