package com.aga;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentTestMto1 {

	public static void main(String[] args) {
		// Configure the db using xml file
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			
			AddressMto1 add1 = new AddressMto1("23, Laxmi Nagar","Jaipur","Rajasthan", "302012");
			AddressMto1 add2 = new AddressMto1("202, Dadu Mandir","Hissar","Haryana", "590001");
			
			StudentMto1 s1 = new StudentMto1();
			s1.setStudentName("RAKESH KEDIA");
			
			s1.getAddress().add(add1);
			s1.getAddress().add(add2);
			
			add1.setStudent(s1);
			add2.setStudent(s1);
			
			session.save(s1);
			session.save(add1);
			session.save(add2);
			
			tx.commit();
			session.close();
			sf.close();
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();
		}
	}

}

/*		-- Bidirectional many-to-one using @Jointable annotation (Default Approach)
create table AddressMto1(
	addressId bigint not null auto_increment,
    city varchar(255),
    state varchar(255),
    street varchar(255),
    zipcode varchar(255),
    primary key (addressId)
);

create table StudentMto1(
	studentId bigint not null auto_increment,
    studentName varchar(255),
    primary key(studentId)
);
create table StudentMto1_AddressMto1(
ADDRESS_FK bigint,
    STUDENT_FK bigint NOT NULL,
    primary key(STUDENT_FK)
);
alter table StudentMto1_AddressMto1
add index STUDADDFK0001 (STUDENT_FK),
add constraint STUDADDFK0001 foreign key (STUDENT_FK) references AddressMto1 (addressId);

alter table StudentMto1_AddressMto1
add index STUDADDFK0012 (ADDRESS_FK),
add constraint STUDADDFK0012 foreign key (ADDRESS_FK) references StudentMto1 (studentId);

select * from AddressMto1;
select * from StudentMto1;
select * from StudentMto1_AddressMto1;	*/