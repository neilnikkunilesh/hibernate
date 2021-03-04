/* 
 	HQL insert also support select after insert
 		SELECT m.messageId, m.senderName, m.sendDate FROM MessageSQL m WHERE m.messageId = 3
 */

package com.aga;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MessageHQLInsertIntoTest {
	
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
				query = "INSERT INTO MessageSQL(messageText, sendDate, senderName)  SELECT m.messageId, m.senderName, m.sendDate FROM MessageSQL m WHERE m.messageId > 2";
				Query q = session.createQuery(query);
				
				// get List from Query
				List<Object[]> list = q.list();
				
				System.out.println("-----------------------------Use of Where Clause---------------------------------------");
				System.out.println("MessageID	SenderName		SendDate");
				for(Object[] obj : list) {
					System.out.print(obj[0]+"		");
					System.out.print(obj[1]+"		");
					System.out.print(obj[2]+"		");
					
					System.out.println();
				}
				
				
				
				session.close();
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}
