package com.aga;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentTest1toM {

	public static void main(String[] args) {
		// Configure the db using xml file
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		//@OneToMany and @ManyToOne annotation example using @JoinColumn Annotation
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			
			Address1toM add1 = new Address1toM("23, Laxmi Nagar","Jaipur","Rajasthan", "302012");
			Address1toM add2 = new Address1toM("202, Dadu Mandir","Hissar","Haryana", "590001");
			
			Student1toM s1 = new Student1toM();
			s1.setStudentName("RAKESH KEDIA");
			//Student121 s2 = new Student121();
			
			add1.setStudent1toM(s1);
			add2.setStudent1toM(s1);
			
			session.save(s1);
			session.save(add1);
			session.save(add2);
			
			tx.commit();
			session.close();
			//session.save(s2);
			/* In Unidirectional approach obtaining AddressExplicit from StudentExplicit is possible
			 * but Obtaining StudentExplicit from AddressExplicit is not possible. This is possible
			 * only  in Bidirectional approach.Show below code:
			 * */
			 
			sf.close();
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();
		}
	}

}
/*	-- @OneToMany and @ManyToOne annotation example using @JoinColumn Annotation
create table Address1toM(
	addressId bigint not null auto_increment,
    city varchar(255),
    state varchar(255),
    street varchar(255),
    zipcode varchar(255),
    STUDENT_FK bigint,
    primary key (addressId)
);

create table Student1toM(
	studentId bigint not null auto_increment,
    studentName varchar(255),
    primary key(studentId)
);
alter table Address1toM
add index STUDFK0001 (STUDENT_FK),
add constraint STUDFK0001 foreign key (STUDENT_FK) references Student1toM (studentId);

select * from Address1toM;
select * from Student1toM;	*/
