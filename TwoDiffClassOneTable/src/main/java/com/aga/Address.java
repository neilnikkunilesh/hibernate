package com.aga;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String street;
	
	@Column(nullable = false, length = 50)
	private String city;
	
	@Column(name = "ADDRESS_STATE" ,nullable = false, length = 50)
	private String state;
	
	@Column(name = "ADDRESS_ZIPCODE" ,nullable = false, length = 10)
	private String zipcode;
	
	public Address() {
		
	}
	
	
	public Address(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
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
	
	
}
