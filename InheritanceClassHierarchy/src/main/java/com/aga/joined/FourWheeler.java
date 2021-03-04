package com.aga.joined;

import javax.persistence.Entity;

/* If no PrimaryKeyColumn annotation is specified for a subClass in the JOINED mapping
 * strategy, the foreign key column are assumed to have the same names as the primary key column of the primary table 
 * of the superclass (see in FourWheeler Table)	*/
@Entity
public class FourWheeler extends Vehicle{
	
	private String steeringWheel;

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
	
}
