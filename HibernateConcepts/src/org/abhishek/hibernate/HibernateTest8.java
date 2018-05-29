package org.abhishek.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.FourWheeler;
import org.hibernatedemo.abhishek.dto.TwoWheeler;
import org.hibernatedemo.abhishek.dto.Vehicle;

public class HibernateTest8 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Inheritance - Table Per Class
		// 2. Inheritance - Joined Strategy
		
		
		
		// To test the different inheritance strategies, experiment with the InheritanceType value of
		// @Inheritance annotation in Vehicle entity
		//1.  @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
		//2.  @Inheritance(strategy=InheritanceType.JOINED)
		
	

		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleName("Vehicle");

			TwoWheeler bike = new TwoWheeler();
			bike.setSteeringHandle("Steering Handle");
			bike.setVehicleName("Bike");

			FourWheeler car = new FourWheeler();
			car.setSteeringWheel("Steering wheel");
			car.setVehicleName("Car");
			
			session.save(vehicle);
			session.save(bike);
			session.save(car);
			
			session.getTransaction().commit();
			session.close();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
