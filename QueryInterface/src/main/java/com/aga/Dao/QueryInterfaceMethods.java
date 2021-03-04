package com.aga.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.aga.database.SessionObject;
import com.aga.pojo.Books;

public class QueryInterfaceMethods {
	
	public void createBooks() {
		System.out.println( "Inside Create Books");
		Session session=null;
		Transaction tx =null;
		Books b1 = new Books(101, "Hibernate", 421, 199, 1001, 1002, 1003, 1004);
		Books b2 = new Books(102, "Struts", 422, 502, 1001, 1002, 1003, 1004);
		Books b3 = new Books(103, "JSP", 423, 503, 1011, 1012, 1013, 1014);
		Books b4 = new Books(104, "Spring", 423, 602, 603, 1011, 1013, 1014);
		Books b5 = new Books(105, "Oracle", 424, 199, 10101, 10102, 10103, 10104);
		Books b6 = new Books(106, "PHP", 421, 199, 10123, 10124, 10125, 10126);
		try
		{
			session= SessionObject.getSession();
			tx = session.beginTransaction();
			
			session.save(b1);
			session.save(b2);
			session.save(b3);
			session.save(b4);
			session.save(b5);
			session.save(b6);
			
			tx.commit();
			System.out.println("Record Added Sucessfully");
			
		}catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void listDemo() {
		Session session = null;
		try {
			session = SessionObject.getSession();
			Query q = session.createQuery("FROM Books b");
			List<Books> list = q.list();
			
			for(Books obj : list) {
				System.out.print(obj.getBookNo()+"		");
				System.out.print(obj.getBookName()+"		");
				System.out.print(obj.getPublisherNo()+"		");
				System.out.print(obj.getCost()+"		");
				System.out.print(obj.getAuthor1No()+"		");
				System.out.print(obj.getAuthor2No()+"		");
				System.out.print(obj.getAuthor3No()+"		");
				System.out.print(obj.getAuthor4No()+"		");
				
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
	}
	
	public void uniqueResutl() {
		Session session = null;
		
		try {
			session = SessionObject.getSession();
			Query q = session.createQuery("FROM Books b WHERE b.bookNo=? and b.bookName=?")
					.setParameter(0, 3)
					.setParameter(1, "JSP");
			Books book = (Books)q.uniqueResult();
			
			System.out.print(book.getBookNo()+"		");
			System.out.print(book.getBookName()+"		");
			System.out.print(book.getPublisherNo()+"		");
			System.out.print(book.getCost()+"		");
			System.out.print(book.getAuthor1No()+"		");
			System.out.print(book.getAuthor2No()+"		");
			System.out.print(book.getAuthor3No()+"		");
			System.out.print(book.getAuthor4No()+"		");
			
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void iteratorDemo() {
		Session session = null;
		
		try {
			session = SessionObject.getSession();
			Query q = session.createQuery("FROM Books b WHERE b.author1No=:author1 and b.author2No = :author2")
					.setParameter("author1", 1011)
					.setParameter("author2",1012);
			Iterator<Books> itr = q.iterate();
			while(itr.hasNext()) {
				Books book = (Books)itr.next();
				System.out.print(book.getBookNo()+"		");
				System.out.print(book.getBookName()+"		");
				System.out.print(book.getPublisherNo()+"		");
				System.out.print(book.getCost()+"		");
				System.out.print(book.getAuthor1No()+"		");
				System.out.print(book.getAuthor2No()+"		");
				System.out.print(book.getAuthor3No()+"		");
				System.out.print(book.getAuthor4No()+"		");
				
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void scrollDemo() {
		Session session = null;
		
		try {
			session = SessionObject.getSession();
			Query q = session.createQuery("FROM Books ");
			ScrollableResults sRset = q.scroll(ScrollMode.SCROLL_INSENSITIVE);
			
			sRset.scroll(2);
			
			while(sRset.next()) {
				Books book = (Books)sRset.get(0);
				System.out.print(book.getBookNo()+"		");
				System.out.print(book.getBookName()+"		");
				System.out.print(book.getPublisherNo()+"		");
				System.out.print(book.getCost()+"		");
				System.out.print(book.getAuthor1No()+"		");
				System.out.print(book.getAuthor2No()+"		");
				System.out.print(book.getAuthor3No()+"		");
				System.out.print(book.getAuthor4No()+"		");
				
				System.out.println();
			}
			//now cursor is on afterLast position
			System.out.println("#############################################");
			sRset.scroll(-1);
			while(sRset.previous()) {
				Books book = (Books)sRset.get(0);
				System.out.print(book.getBookNo()+"		");
				System.out.print(book.getBookName()+"		");
				System.out.print(book.getPublisherNo()+"		");
				System.out.print(book.getCost()+"		");
				System.out.print(book.getAuthor1No()+"		");
				System.out.print(book.getAuthor2No()+"		");
				System.out.print(book.getAuthor3No()+"		");
				System.out.print(book.getAuthor4No()+"		");
				
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void parameterListDemo() {
		Session session = null;
		
		try {
			session = SessionObject.getSession();
			List<String> names = new ArrayList<String>();
			names.add("Oracle");
			names.add("PHP");
			
			Query q = session.createQuery("FROM Books b WHERE b.bookName IN (:nameList)")
					.setParameterList("nameList",names);
					
			List<Books> list = q.list();
			
			for(Books book : list) {
				//Books book = (Books)obj;
				System.out.print(book.getBookNo()+"		");
				System.out.print(book.getBookName()+"		");
				System.out.print(book.getPublisherNo()+"		");
				System.out.print(book.getCost()+"		");
				System.out.print(book.getAuthor1No()+"		");
				System.out.print(book.getAuthor2No()+"		");
				System.out.print(book.getAuthor3No()+"		");
				System.out.print(book.getAuthor4No()+"		");
				
				System.out.println();
			}
		} catch (Exception e) {
			System.err.println("Error Inside parameterListDemo()");
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
	public void setCommentDemo() {
		Session session = null;
		
		try {
			session = SessionObject.getSession();
			Query q = session.createQuery("FROM Books b WHERE b.author1No=:author1 and b.author2No = :author2")
					.setParameter("author1", 1011)
					.setParameter("author2",1012);
			q.setComment(">>>>>>>>>>>>>>>>>>>>>>>>>>> Comment by Nilesh Gupta");
			Iterator<Books> itr = q.iterate();
			while(itr.hasNext()) {
				Books book = (Books)itr.next();
				System.out.print(book.getBookNo()+"		");
				System.out.print(book.getBookName()+"		");
				System.out.print(book.getPublisherNo()+"		");
				System.out.print(book.getCost()+"		");
				System.out.print(book.getAuthor1No()+"		");
				System.out.print(book.getAuthor2No()+"		");
				System.out.print(book.getAuthor3No()+"		");
				System.out.print(book.getAuthor4No()+"		");
				
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}
	
}
