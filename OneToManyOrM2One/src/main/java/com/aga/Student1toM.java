package com.aga;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Student1toM")
public class Student1toM {

	@Id
	@GeneratedValue
	@Column(name = "studentId")
	private long studentId;
	
	@Column(name = "studentName", length = 100, nullable = false)
	private String studentName;
	
	@OneToMany(targetEntity = Address1toM.class, mappedBy = "student1toM",
				cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Address1toM> address;

	public Student1toM() {
		
	}

	public Student1toM(String studentName, Set<Address1toM> address) {
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

	public Set<Address1toM> getAddress() {
		return address;
	}

	public void setAddress(Set<Address1toM> address) {
		this.address = address;
	}

	
	
}
