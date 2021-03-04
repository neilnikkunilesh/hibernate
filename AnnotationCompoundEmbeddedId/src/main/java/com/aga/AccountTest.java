package com.aga;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class AccountTest {
	
	public static void main(String[] args) {
		
		AnnotationConfiguration configuration = new AnnotationConfiguration().configure("account.cfg.xml");;
		configuration.addAnnotatedClass(Account.class);
		
		
		SessionFactory sf = configuration.buildSessionFactory();
		Session session= sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		AccountPk key1 = new AccountPk("logitech", new Integer(2005));
		Account savingAccount = new Account();
		savingAccount.setCompositeId(key1);
		savingAccount.setAccountBalance(10000);
		
		AccountPk key2 = new AccountPk("Oshine", new Integer(2006));
		Account currentAccount = new Account();
		currentAccount.setCompositeId(key2);
		currentAccount.setAccountBalance(5000);
		
		System.out.println(key1.equals(key2));
		AccountPk id1= (AccountPk)session.save(savingAccount);
		AccountPk id2= (AccountPk)session.save(currentAccount);
		
		transaction.commit();
		session.close();
		sf.close();
		
		
	}
}
