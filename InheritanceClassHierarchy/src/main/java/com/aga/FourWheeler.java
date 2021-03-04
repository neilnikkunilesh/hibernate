package com.aga;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
// Here we are not private value it will take default value define in Vehicle @DiscriminatorValue
public class FourWheeler extends Vehicle{

	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
}
