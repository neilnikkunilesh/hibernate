package com.aga.tableperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverrides({
	@AttributeOverride(name = "vehicleName", column = @Column(name = "Name_of_Vehicle")),
	@AttributeOverride(name = "vehicleLicenseNo", column = @Column(name = "License_No"))
})
public class TwoWheeler extends Vehicle {

	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	
}
