package com.aga;

import java.math.BigDecimal;
import java.util.Date;

import javax.security.auth.login.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class VehicleTest {

	public static void main(String[] args) {
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
		
		try {
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
				
				// config the db details
				sf = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
				//get the session using session factory object
				session = sf.openSession();
				tx = session.beginTransaction();
				
				//  save the session to db
				session.save(bus);
				session.save(bike);
				session.save(car);
				
				// commit the transaction
				tx.commit();
				// close the session
				session.close();
				sf.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		

	}

}
/*	-- Create Database Table to persiste Class Hierarchy : The Vehicle table will store Vehicle TwoWheeler and FourWheeler objects.
drop table if exists Vehicle;
CREATE TABLE Vehicle(
	vehicleType VARCHAR(31) NOT NULL,
    vehicleId INTEGER NOT NULL AUTO_INCREMENT,
    vehicleLicenseNo VARCHAR(255),
    vehicleName VARCHAR(255),
    steeringHandle VARCHAR(255),
    steeringWheel VARCHAR(255),
    PRIMARY KEY(vehicleId)
);
select * from Vehicle;
*/