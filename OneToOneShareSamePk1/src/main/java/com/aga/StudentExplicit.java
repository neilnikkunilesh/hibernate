package com.aga;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTEXPLICIT")
public class StudentExplicit {

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long studentId;
	
	@Column(name = "STUDENT_NAME", length = 100, nullable = false)
	private String studentName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ADDRESS_FK", referencedColumnName = "ADDRESS_ID")
	// if do not mentioned a foreign key column name then by default address_ADDRESS_ID
	private AddressExplicit addressExplicit;

	public StudentExplicit() {
		
	}
	public StudentExplicit(String studentName, AddressExplicit addressExplicit) {
		super();
		this.studentName = studentName;
		this.addressExplicit = addressExplicit;
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

	public AddressExplicit getAddressExplicit() {
		return addressExplicit;
	}

	public void setAddressExplicit(AddressExplicit addressExplicit) {
		this.addressExplicit = addressExplicit;
	}

	@Override
	public String toString() {
		return "StudentExplicit [studentId=" + studentId + ", studentName=" + studentName + ", addressExplicit="
				+ addressExplicit + "]";
	}

	
	
	
}
