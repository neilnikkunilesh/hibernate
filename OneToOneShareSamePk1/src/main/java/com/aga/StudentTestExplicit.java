package com.aga;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentTestExplicit {

	public static void main(String[] args) {
		// Configure the db using xml file
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			
			AddressExplicit add1 = new AddressExplicit("23, Laxmi Nagar","Jaipur","Rajasthan", "302012");
			//Address add2 = new Address("202, Dadu Mandir","Hissar","Haryana", "590001");
			
			StudentExplicit s1 = new StudentExplicit("RAKESH KEDIA", add1);
			//Student121 s2 = new Student121();
			
			Long id1 = (Long) session.save(s1);
			tx.commit();
			session.close();
			//session.save(s2);
			/* In Unidirectional approach obtaining AddressExplicit from StudentExplicit is possible
			 * but Obtaining StudentExplicit from AddressExplicit is not possible. This is possible
			 * only  in Bidirectional approach.Show below code:
			 * */
			
			  session = sf.openSession(); StudentExplicit studentExplicitObj =
			  (StudentExplicit) session.get(StudentExplicit.class, id1);
			  
			  System.out.println("Obtaining Student Information form Student object: \n");
			  System.out.println("Student Name: "+studentExplicitObj.getStudentName());
			  System.out.println();
			  
			  System.out.println("Obtaining Address Information from Student Object:  \n");
			  AddressExplicit addressExplicitObj = studentExplicitObj.getAddressExplicit();
			  //System.out.println(addressExplicitObj);
			  System.out.println(addressExplicitObj.getStreet()+" "+ addressExplicitObj.getCity()+" "
					 + addressExplicitObj.getState()+" "+addressExplicitObj.getZipcode());
			  
			  System.out.println("Obtaining Student Information from Address Object: \n");
			  StudentExplicit studentExplicitObj2 =
			  addressExplicitObj.getStudentExplicit();
			  System.out.println("Student Name: "+studentExplicitObj2.getStudentName());
			  
			  System.out.
			  println("\n The reference obtained from Address reference to its owning entity, to test this we can"
			  +
			  " equate the reference 'studentExplicitObj' and 'studentExplicitObj2' Resutl= "
			  +(studentExplicitObj==studentExplicitObj2));
			  
			 
			session.close();
			sf.close();
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();
		}
	}

}
