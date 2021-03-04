package com.aga;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeTest {

	public static void main(String... args) {

		// Creating a new Persistent State
		Employee objEmp = new Employee();
		objEmp.setDeptNo(011);
		objEmp.setEmpName("Shiva Yullu");
		objEmp.setEmpDesignation("Software Developer");
		objEmp.setEmpSalary(35000.0);
		objEmp.setEmpJoiningDate(new Date());

		EmployeeTest test = new EmployeeTest();
		test.insertEmployee(objEmp);

		// Updating the Persistent State
		//test.updateEmployee(objEmp);

		// Getting an Employee
		//objEmp = test.getEmployee(2);

		if (objEmp != null) {
			System.out.println("Employee Details of empno: " + objEmp.getEmpNo());
			System.out.println("Employee Details of empno: " + objEmp.getEmpName());
			System.out.println("Employee Details of empno: " + objEmp.getEmpDesignation());
			System.out.println("Employee Details of empno: " + objEmp.getEmpSalary());
			System.out.println("Employee Details of empno: " + objEmp.getEmpJoiningDate());

		}

		// Deleting an Employee
		/*
		 * if (objEmp != null) { test.deleteEmployee(objEmp); }
		 */
	}

	public void insertEmployee(Employee objEmp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(objEmp); // Persist the given transient instance, first assigning a generated identifier

			// session.persist(objEmp); // Make a transient instance persistent.

			transaction.commit();
			System.out.println("Employee inserted with empNo. " + objEmp.getEmpNo());
		} catch (HibernateException he) {
			transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void updateEmployee(Employee objEmp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {

			transaction = session.beginTransaction();
			// contains Check if this instance is associated with this Session.
			System.out.println("objEmp is persistable object (check before transaction): " + session.contains(objEmp));

			// objEmp is now detached instance
			objEmp.setEmpDesignation("Project Manager");
			objEmp.setEmpSalary(40000);

			session.update(objEmp); // used with detached instance to be persisted
			System.out.println("objEmp is persistable object (check after update): " + session.contains(objEmp));
			System.out.println("Employee Updated with EmpDesignation & EmpSalary:" + objEmp.getEmpDesignation());

//			 session.evict(objEmp); //used with persisted instance to be detached
//			 System.out.println("objEmp is persistable object(check after evict): "+session.contains(objEmp));
//			 
//			 // objEmp is now detached instance
//			 objEmp.setEmpDesignation("Sr. Project Manger");
//			 objEmp.setEmpSalary(45000);
//			 session.refresh(objEmp);// refresh an instance of a persistent object

//			 System.out.println("objEmp is persistable object(check after refresh):"+ session.contains(objEmp));
//			 System.out.println("Employee Updated with EmpDesignation & EmpSalary: "+objEmp.getEmpDesignation()+" "+objEmp.getEmpSalary());
//			 
//			 session.flush();
			transaction.commit();
		} catch (HibernateException he) {
			transaction.rollback();
			he.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteEmployee(Employee objEmp) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(objEmp); // objEmp is now become transient instance
			
//			session.flush();
			transaction.commit();
			System.out.println("objEmp is persistable object(check after delete):"+session.contains(objEmp));
			System.out.println("Employee Removed with EmpNo: "+ objEmp.getEmpNo());
		}catch(HibernateException he) {
			transaction.rollback();
			he.printStackTrace();
		}finally {
			session.close();
		}
	}

	public Employee getEmployee(int empNo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Employee objEmp = null;
		try {
			objEmp = (Employee) session.get(Employee.class, new Integer(empNo)); //return null if not found
			objEmp = (Employee)session.load(Employee.class, new Integer(empNo)); //return exception if not found
		} catch (HibernateException he) {
			he.printStackTrace();
		}finally {
			session.close();
		}
		return objEmp;
	}

}
