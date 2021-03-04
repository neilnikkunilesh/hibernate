package com.aga;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "StudentMto1")
public class StudentMto1 {

	@Id
	@GeneratedValue
	@Column(name = "studentId")
	private long studentId;
	
	@Column(name = "studentName", length = 100, nullable = false)
	private String studentName;
	
	@OneToMany(mappedBy = "student")
	private Collection<AddressMto1> address = new ArrayList<AddressMto1>();

	public StudentMto1() {
		
	}
	public StudentMto1(String studentName) {
		super();
		this.studentName = studentName;
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
	public Collection<AddressMto1> getAddress() {
		return address;
	}
	public void setAddress(Collection<AddressMto1> address) {
		this.address = address;
	}
	
}