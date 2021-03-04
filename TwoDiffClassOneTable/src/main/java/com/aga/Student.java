package com.aga;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long studentId;
	
	@Column(name = "STUDENT_NAME", length = 100, nullable = false)
	private String studentName;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "street", column = @Column(name = "ADDRESS_STREET", nullable = false, length = 250)),
		@AttributeOverride(name = "city", column = @Column(name="ADDRESS_CITY"))
	})
	private Address studentAddress;
	
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
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	
	public Student(String studentName, Address studentAddress) {
		super();
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}
	
	
	
	
}
