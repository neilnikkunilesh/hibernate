package com.aga;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MessageTest {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
				Message msg = new Message();
				msg.setMessageTitle("BIRTHDAY");
				msg.setMessageText("Happy Birthday Dear Rakesh Kedia");
				msg.setMessageReceivedDate(new Date());
				msg.setMessageSendBy("Bhawani Singh");
				msg.setMessageSendDate(new Date());
				msg.setMessageSendTime(new Date());
				msg.setMessageCost(new BigDecimal(11.55));
			
				Message msg2 = new Message();
				msg2.setMessageTitle("MARRIAGE ANNIVERSARY");
				msg2.setMessageText("Happy Marriage Anniversary Dear Prateek Patel");
				msg2.setMessageReceivedDate(new Date());
				msg2.setMessageSendBy("Rajesh Kotil");
				msg2.setMessageSendDate(new Date());
				msg2.setMessageSendTime(new Date());
				msg2.setMessageCost(new BigDecimal(9.20));
				
			
				// config the db details
				sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
				//get the session using session factory object
				session = sf.openSession();
				tx = session.beginTransaction();
				
				//  save the session to db
				session.save(msg);
				session.save(msg2);
				
				// commit the transaction
				tx.commit();
				// close the session
				session.close();
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}
