package org.abhishek.hibernate;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.DistributionMedium;
import org.hibernatedemo.abhishek.dto.OnlineDistribution;
import org.hibernatedemo.abhishek.dto.TheatreDistribution;

public class HibernateTest7 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Inheritance - Single Table Strategy
		// 2. Inheritance - Table Per Class
		// 3. Inheritance - Joined Strategy
		
		// To test the different inheritance strategies, experiment with the InheritanceType value of
		// @Inheritance(strategy=InheritanceType.SINGLE_TABLE) annotation in DistributionMedium entity
		
		// The different entities inheriting a base entity are distinguished from each other
		// with the help of DTYPE column. This column is named DTYPE by default. To give it a meaningful name
		// use the @DiscriminatorColumn annotation as used in the DistributionMedium entity.
		
		//Even the value in DiscriminatorType column can be specified by using the @DiscriminatorValue annotation

		SessionFactory sessionFactory;
		Session session = null;
		
		try {

			sessionFactory = new Configuration().configure().buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();

			DistributionMedium distMedium = new DistributionMedium();
			distMedium.setRightsValue("50000000");

			TheatreDistribution theatreDist = new TheatreDistribution();
			theatreDist.setRightsValue("60000000");
			theatreDist.setSeatingCapacity("500");
			theatreDist.setTheatreName("Priya");

			OnlineDistribution onlineDist = new OnlineDistribution();
			onlineDist.setRightsValue("400000000");
			onlineDist.setStreamingPartner("Netflix");
			onlineDist.setSubscriberBase("3867000");
			
			session.save(distMedium);
			session.save(theatreDist);
			session.save(onlineDist);
			
			

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally{
			if(session!=null){
				session.getTransaction().commit();
				session.close();
				}
		}
	}

}
