/* 
 	In memory entities will not be updated to reflect changes resulting form issuing UPDATE statement.
 	Object can be given an alias name to abbreviate reference to specific objects or their properties.
 	and must be used when property names used in the query would otherwise be ambiguous.
 	
 	UPDATE MessageSQL m SET m.senderName = :newName WHERE m.senderName = :oldName
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

public class MessageHQLUpdateTest {
	
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
				
				System.out.println("-----------------------------Befor Update operator---------------------------------------");
				
			/*
			 * String selectQ = "from MessageSQL m"; Query queryQ =
			 * session.createQuery(selectQ); List<MessageSQL> li = queryQ.list();
			 * 
			 * for(Object data : li) { MessageSQL msg= (MessageSQL)data;
			 * System.out.print(msg.getMessageId()+"	");
			 * System.out.print(msg.getSenderName()+"	");
			 * System.out.print(msg.getSendDate()+"	");
			 * 
			 * System.out.println(); }
			 * 
			 * String update_query =
			 * "UPDATE MessageSQL m SET m.senderName = :newSenderName WHERE m.senderName =:oldSenderName"
			 * ; Query updateResult = session.createQuery(update_query);
			 * updateResult.setParameter("newSenderName", "Indian Gov");
			 * updateResult.setParameter("oldSenderName", "PMO India"); int rowAffected =
			 * updateResult.executeUpdate();
			 * System.out.println("No of Updated Row: "+rowAffected); tx.commit();
			 * session.close();
			 * 
			 * System.out.
			 * println("-----------------------------After Update operator---------------------------------------"
			 * ); session = sf.openSession(); String selectQuery = "from MessageSQL m";
			 * Query query3 = session.createQuery(selectQuery); List<MessageSQL> list =
			 * query3.list();
			 * 
			 * for(Object data : list) { MessageSQL msg= (MessageSQL)data;
			 * System.out.print(msg.getMessageId()+"	");
			 * System.out.print(msg.getSenderName()+"	");
			 * System.out.print(msg.getSendDate()+"	");
			 * 
			 * System.out.println(); }
			 */
				
				// In memory entities will not to followed for deletion carried out using HQL
				String delete_query = "DELETE MessageSQL m  WHERE m.messageId =:oldMessageId";
				Query deleteResult = session.createQuery(delete_query).setParameter("oldMessageId", 12);
				int rowAffectedDel = deleteResult.executeUpdate();
				System.out.println("No of Delete Row: "+rowAffectedDel);
				tx.commit();
				session.close();
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}