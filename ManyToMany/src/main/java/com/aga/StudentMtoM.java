package com.aga;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "StudentMtoM")
public class StudentMtoM {

	@Id
	@GeneratedValue
	@Column(name = "studentId")
	private long studentId;
	
	@Column(name = "studentName", length = 100, nullable = false)
	private String studentName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "StudentMtoM_AddressMtoM",
			joinColumns = @JoinColumn(name = "STUDENT_FK"),
			inverseJoinColumns = @JoinColumn(name = "ADDRESS_FK"))
	private Collection<AddressMtoM> address = new ArrayList<AddressMtoM>();

	public StudentMtoM() {
		
	}
	public StudentMtoM(String studentName) {
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
	public Collection<AddressMtoM> getAddress() {
		return address;
	}
	public void setAddress(Collection<AddressMtoM> address) {
		this.address = address;
	}
	
}
