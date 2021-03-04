package com.aga;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT121")
public class Student121 {

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long studentId;
	
	@Column(name = "STUDENT_NAME", length = 100, nullable = false)
	private String studentName;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Address address;

	
	public Student121(String studentName, Address address) {
		super();
		this.studentName = studentName;
		this.address = address;
	}

	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
