package com.aga;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESSLINK")
public class AddressLink {

	@Id
	@GeneratedValue
	@Column(name = "ADDRESS_ID")
	private long id;
	
	@Column(name = "ADDRESS_STREET" ,nullable = false, length = 50)
	private String street;
	
	@Column(name = "ADDRESS_CITY" ,nullable = false, length = 255)
	private String city;
	
	@Column(name = "ADDRESS_STATE" ,nullable = false, length = 50)
	private String state;
	
	@Column(name = "ADDRESS_ZIPCODE" ,nullable = false, length = 10)
	private String zipcode;
	
	
	public AddressLink() {
		
	}

	public AddressLink(String street, String city, String state, String zipcode) {
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


	@Override
	public String toString() {
		return "AddressExplicit [id=" + id + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode="
				+ zipcode + "]";
	}
	
	
	
}
