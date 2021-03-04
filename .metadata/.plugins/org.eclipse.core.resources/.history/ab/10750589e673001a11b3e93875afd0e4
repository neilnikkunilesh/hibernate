package com.aga;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address1toM")
public class Address1toM {

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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "STUDENT_FK")
	private Student1toM student1toM;
	
	public Address1toM() {
		
	}

	public Address1toM(String street, String city, String state, String zipcode) {
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

	public Student1toM getStudent1toM() {
		return student1toM;
	}

	public void setStudent1toM(Student1toM student1toM) {
		this.student1toM = student1toM;
	}

	@Override
	public String toString() {
		return "AddressExplicit [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}
	
	
	
}
