/*	
 * @author Nilesh Gupta
 * @version 1.0
 * @since 26--3-2020
 * 
 * HB Support following Joins:
 * 	1.	Inner Join
 * 	2.	Left Outer Join
 * 	3.	Right Outer Join
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

public class QueryInterfaceTest {
	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;

		try {
			/*
			 * sf = new
			 * AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory(
			 * ); session = sf.openSession(); tx = session.beginTransaction();
			 */
			
			QueryInterfaceMethods qim = new QueryInterfaceMethods();
			//qim.createBooks();
			System.out.println("---------------------------- listDemo ----------------------------");
			qim.listDemo();
			System.out.println("---------------------------- uniqueResutl ----------------------------");
			qim.uniqueResutl();
			System.out.println("---------------------------- scrollDemo ----------------------------");
			qim.scrollDemo();
			System.out.println("---------------------------- parameterListDemo ----------------------------");
			qim.parameterListDemo();
			System.out.println("---------------------------- setCommentDemo ----------------------------");
			qim.setCommentDemo();
			

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
