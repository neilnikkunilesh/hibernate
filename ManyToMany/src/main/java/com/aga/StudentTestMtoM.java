package com.aga;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class StudentTestMtoM {

	public static void main(String[] args) {
		// Configure the db using xml file
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = sf.openSession();
			tx = session.beginTransaction();
			
			// student1 have Two Address - address1 and address2
			StudentMtoM s1 = new StudentMtoM();
			s1.setStudentName("RAKESH KEDIA");
						
			AddressMtoM add1 = new AddressMtoM("23, Laxmi Nagar","Jaipur","Rajasthan", "302012");
			AddressMtoM add2 = new AddressMtoM("202, Dadu Mandir","Hissar","Haryana", "590001");
			
			
			
			// student2 and student2(two brothers) have on same address - address3
			StudentMtoM s2 = new StudentMtoM();
			s2.setStudentName("BHAWANI SINGH");
			
			StudentMtoM s3 = new StudentMtoM();
			s3.setStudentName("VINOD SINGH");
			
			
			AddressMtoM add3 = new AddressMtoM("420, Maheshvari Road","Dhori-IshwarPur","Jhunjhunu_Raj", "333024");
			
			/*	**************************	*/
			
			// student1 have Two Address - address1 and address2
			s1.getAddress().add(add1);
			s1.getAddress().add(add2);
			add1.getStudent().add(s1);
			add2.getStudent().add(s1);
			
			// student2 and student3(two brothers) have on same address - address3
			s2.getAddress().add(add3);
			s3.getAddress().add(add3);
			add3.getStudent().add(s2);
			add3.getStudent().add(s3);
			
			/*	**************************	*/
			
			session.save(s1);
			session.save(add1);
			session.save(add2);
			
			session.save(s2);
			session.save(s3);
			session.save(add3);
			
			tx.commit();
			session.close();
			sf.close();
			
		} catch (HibernateException e) {
			//tx.rollback();
			e.printStackTrace();
		}
	}

}

/*		-- A Bidirectional one-to-one using JoinTable Annotation (Default Approach)
create table AddressMtoM(
	addressId bigint not null auto_increment,
    city varchar(255),
    state varchar(255),
    street varchar(255),
    zipcode varchar(255),
    primary key (addressId)
);
create table StudentMtoM(
	studentId bigint not null auto_increment,
    studentName varchar(255),
    primary key(studentId)
);

create table StudentMtoM_AddressMtoM(
    STUDENT_FK bigint NOT NULL,
    ADDRESS_FK bigint NOT NULL
);

alter table StudentMtoM_AddressMtoM
add index FKM2M0001 (STUDENT_FK),
add constraint FKM2M0001 foreign key (STUDENT_FK) references StudentMtoM (studentId);

alter table StudentMtoM_AddressMtoM
add index FKM2M0012 (ADDRESS_FK),
add constraint FKM2M0012 foreign key (ADDRESS_FK) references AddressMtoM (addressId);

select * from AddressMtoM;
select * from StudentMtoM;
select * from StudentMtoM_AddressMtoM;

drop table StudentMtoM_AddressMtoM;
drop table StudentMtoM;
drop table AddressMtoM;	*/