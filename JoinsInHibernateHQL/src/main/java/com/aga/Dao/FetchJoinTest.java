/*	
 * @author Nilesh Gupta
 * @version 1.0
 * @since 26--3-2020
 * 
 * Fetching Associations
 * 
 * 	
 * */
package com.aga.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.aga.pojo.Authors;
import com.aga.pojo.Books;

public class FetchJoinTest {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session	=	null;
		Transaction tx	=	null;
		
		try {
			sf	=	new	AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx	=	session.beginTransaction();
			/*
			 	By default, HB 3 usesLazy SELECT fetching for collections and Lazy PROXY fetching for single-valued associations.
			 	These defaults make sense for almost all association in almost application.
			 	
			 	In lazy collections fetching, a collection is fetched when the application invokes an operation upon that collection.
			 	
			 	FETCH JOIN allows fully initializing an object along with the its associated collection. It forces a lazy association
			 	to be initialized.
			 	
			 	In normal join only the parent objects are included in the result, wheras, in the FETCH JOIN all the parent
			 	object along with ans all child objects are retrieved, in a single SELECT.
			 	*/
				System.out.println("------------------------- FETCH JOIN -------------------------");
				
				
				Query q	= session.createQuery("FROM Books b JOIN FETCH b.authors a");
				List<Object[]> list = q.list();
				
				for(Object[] book : list) {
					  Books b = (Books)book[0];
					  Authors a = (Authors)book[1];
					  if(b!=null) {
						  System.out.print(b.getBookNo()+"		");
						  System.out.print(b.getBookName()+"		");
						  System.out.print(b.getIsbn()+"		");
						  System.out.print(b.getAuthors().getAuthorNo()+"		");
						  System.out.print(b.getAuthors().getAuthorName()+"		");
						  System.out.print(b.getAuthors().getAddress()+"		");
						  System.out.print(b.getAuthors().getEmail()+"		");
						  
						  System.out.println();
					  }
					  
				  }
						
			
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
