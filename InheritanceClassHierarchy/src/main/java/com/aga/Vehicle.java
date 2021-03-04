package com.aga;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
@Inheritance(strategy =  InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vehicleType", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "Vehicle_BUS")
public class Vehicle {
	
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleLicenseNo;
	private String vehicleName;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String vehicleLicenseNo, String vehicleName) {
		super();
		this.vehicleLicenseNo = vehicleLicenseNo;
		this.vehicleName = vehicleName;
	}

	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleLicenseNo() {
		return vehicleLicenseNo;
	}
	public void setVehicleLicenseNo(String vehicleLicenseNo) {
		this.vehicleLicenseNo = vehicleLicenseNo;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	
}
