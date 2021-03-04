package com.aga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AccountTestIdClass {

	public static void main(String[] args) {
		// Configure the ab connection file
		AnnotationConfiguration config = new AnnotationConfiguration().configure("account.cfg.xml").addAnnotatedClass(AccountIdClass.class);
		
		// get the session factory object using config object
		SessionFactory sf = config.buildSessionFactory();
		// open new session 
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
		AccountIdClass savingAccount = new AccountIdClass();
		savingAccount.setUserId("John");
		savingAccount.setAccountNumber(200023453);
		savingAccount.setAccountBalance(12000);
		
		AccountIdClass currentAccount = new AccountIdClass();
		currentAccount.setUserId("Smith");
		currentAccount.setAccountNumber(200023454);
		currentAccount.setAccountBalance(5000);
		
		AccountPk id1 = (AccountPk)session.save(savingAccount);
		AccountPk id2 = (AccountPk)session.save(currentAccount);
		
		
		AccountIdClass ac1 = (AccountIdClass)session.get(AccountIdClass.class, id1);
		AccountIdClass ac2 = (AccountIdClass)session.get(AccountIdClass.class, id2);
		
		System.out.println("Saving account balance is:"+ac1.getAccountBalance());
		System.out.println("Current account balance is:"+ac2.getAccountBalance());
		
		tx.commit();
		session.close();
		sf.close();
		}
		catch(Exception e) {
			tx.rollback();
		}

	}

}
