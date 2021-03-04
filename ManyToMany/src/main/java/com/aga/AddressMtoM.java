package com.aga;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AddressMtoM")
public class AddressMtoM {

	@Id
	@GeneratedValue
	@Column(name = "addressId")
	private long id;
	
	@Column(name = "street" ,nullable = false, length = 50)
	private String street;
	
	@Column(name = "city" ,nullable = false, length = 255)
	private String city;
	
	@Column(name = "state" ,nullable = false, length = 50)
	private String state;
	
	@Column(name = "zipcode" ,nullable = false, length = 10)
	private String zipcode;
	
	@ManyToMany(mappedBy = "address")
	private Collection<StudentMtoM> student =new ArrayList<StudentMtoM>();
	
	
	public AddressMtoM() {
		
	}

	public AddressMtoM(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Collection<StudentMtoM> getStudent() {
		return student;
	}

	public void setStudent(Collection<StudentMtoM> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "AddressMto1 [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + ", student=" + student + "]";
	}

	
	
	
	
}