package com.aga.tableperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.TableGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

	@Id
	@TableGenerator(name = "tablegen", table = "key_generator_vehicle", pkColumnName = "pk_id",
			pkColumnValue = "pk_value", valueColumnName = "next_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "tablegen")
	private int vehicleId;
	private String vehicleLicenseNo;
	private String vehicleName;
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
