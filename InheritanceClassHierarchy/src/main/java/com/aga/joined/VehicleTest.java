package com.aga.joined;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.aga.joined.FourWheeler;
import com.aga.joined.TwoWheeler;
import com.aga.joined.Vehicle;

public class VehicleTest {
	public static void main(String args[]) {
		SessionFactory sf =null;
		Session session = null;
		Transaction tx = null;
		
		try {
		sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		
		Vehicle bus = new Vehicle();
		bus.setVehicleName("BUS");
		bus.setVehicleLicenseNo("RJ14-BS-6709");
		
		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("BIKE");
		bike.setVehicleLicenseNo("RJ15-US-2020");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler();
		car.setVehicleName("CAR");
		car.setVehicleLicenseNo("RJ29-1M-4992");
		car.setSteeringWheel("Car Steering Wheel");
		
		session.save(bus);
		session.save(bike);
		session.save(car);
		tx.commit();
		session.close();
		sf.close();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}

/*	-- In the previous example we have to only change the inderitance strategy to
-- InhertanceType.JOINED and remove the @DiscriminatroColumn annotation and @DiscriminatroValue
alter table FourWheeler
	drop foreign key FK5962B0FOUR;

alter table TwoWheeler
	drop foreign key FK5962B0TWO;

drop table if exists FourWheeler;
drop table if exists TwoWheeler;
drop table if exists Vehicle;

create table FourWheeler(
	steeringWheel varchar(255),
    vehicleId integer not null,
    primary key(vehicleId)
);

create table TwoWheeler(
	steeringHandle varchar(255),
    vehicleId integer not null,
    primary key(vehicleId)
);
create table Vehicle(
	vehicleId integer not null auto_increment,
    vehicleLicenseNo varchar(255),
    vehicleName varchar(255),
    primary key(vehicleId)
);

alter table FourWheeler
	add index FK5962B0FOUR (vehicleId),
    add constraint FK5962B0FOUR
    foreign key (vehicleId) references Vehicle (vehicleId);

alter table TwoWheeler
	add index FK5962B0TWO (vehicleId),
    add constraint FK5962B0TWO
    foreign key (vehicleId) references Vehicle(vehicleId)
    	*/