package com.aga.Dao;

import java.awt.print.Book;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.aga.pojo.Authors;
import com.aga.pojo.Books;

public class BookAuthorInsertDataTest {

	public static void main(String[] args) {
		
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			
			Authors author1 = new Authors("Devesh Gupta","Barkat nagar", "deveshguptajpr@gmail.com");
			Books book1 = new Books("Core Java","555-444-222",author1);
			
			Books book2 = new Books("Advance Java","555-111222-9980",author1);
			
			Authors author2 = new Authors("Amish Tripathi","Mumbai", "author@amishtripathi.com");
			Books book3 = new Books("The Immortals of MELUHA","978-93-80658-74-2",author2);
			Books book4 = new Books("The Secret of the Nagas","978-93-80660-75-1",author2);
			
			Authors author3 = new Authors("Marcel Proust","Landon", "marcelproust@books.com");
			Books book5 = new Books("In Search of Lost Time","9009-12-3456-4545",author3);
			Books book6 = new Books("In the World Forest","9009-123-3456-1234",author3);
			
			
			Authors author4 = new Authors("Chetan Bhagat","Bharat", "chetanb@books.com");
			Books book7 = new Books("Three Mistakes of My life","2001-02-0230-2233",author4);
			
			session.save(book1);
			session.save(book2);
			session.save(book3);
			session.save(book4);
			session.save(book5);
			session.save(book6);
			session.save(book7);
			tx.commit();
			session.close();
			
			session = sf.openSession();
			Query selectQuery = session.createQuery("FROM Books b JOIN b.authors a WHERE a.authorName=:paramAuthName")
					.setParameter("paramAuthName", "Amish Tripathi");
			List<Object[]> result = selectQuery.list();
			System.out.println(result);
			
			  for(Object[] book : result) {
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
				  }
				  
			  }
			 
			session.close();
			sf.close();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}
}
