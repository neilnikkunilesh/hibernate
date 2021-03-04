package com.aga;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="EmployeeInfo")
@Proxy(lazy=false)
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empNo;
	private int deptNo;
	private String empName;
	private String empDesignation;
	private double empSalary;
	private Date empJoiningDate;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public Date getEmpJoiningDate() {
		return empJoiningDate;
	}
	public void setEmpJoiningDate(Date empJoiningDate) {
		this.empJoiningDate = empJoiningDate;
	}
	
	
}
