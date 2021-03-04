/* In the MessageHQLSelectMultipleScalarValuesTest.java Example
  We can observer that the query returns a list containing Object[] array with values as specified in the SELECT clause.
  In the most cases we want the result as list of custom value objects instead of Object[] array.Code snippet shows below:
  
  Query q = session.createQuery("SELECT m.messageId, m.messageText, m.SendDate FROM MessageSQL m");
	List<Object[]> results = q.list();
	List<MessageSQL> myresults = new List<MessageSQL>();
	for(Object[] result : results) {
		myresults.add(new MessageSQL(result[0],result[1],result[3]));
	}
 	use the myresult list that contains MessageSQL result
 	
 	we have to use the above code for our custom requirement to convert Object[] array into list.
 	To meet this requirement the preceding approach has some issues such as increases in memory requirement and unnecessary list iteration.
 	HQL supports these requirement in select clause.  
*/
// Using Constructor Expression in SELECT Clause
/*
 	HQL SELECT clause allows us to specify constructor expression for retrieving a list of custom ValueObject.
 	We have to use HQL construct named NEW specify the constructor expression.
 	
 	SELECT NEW com.aga.MessageSQL(m.messageId, m.messageText, m.senderName) FROM MessageSQL m
 	
 	This query returns a list of custom MessageSQL object. The MessageSQL class must have the constructor matching the constructor used in the query.
 	
 	NOTE:	1.	The specified class need not be a persistent class mapped to the database table.
 			2.	The constructor name must be fully qualified.
 */

package com.aga;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class MessageHQLSelectConstructorExpressionTest {
	
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
				query = "SELECT NEW com.aga.MessageSQL( m.messageId, m.senderName, m.sendDate) FROM MessageSQL m";
				Query q = session.createQuery(query);
				
				// get List from Query
				List<MessageSQL> results = q.list();
				
				System.out.println("MessageID	SenderName		SendDate");
				for(MessageSQL cust : results) {
					System.out.print(cust.getMessageId()+"		");
					System.out.print(cust.getSenderName()+"		");
					System.out.print(cust.getSendDate()+"		");
					
					System.out.println();
				}
				
				
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}
