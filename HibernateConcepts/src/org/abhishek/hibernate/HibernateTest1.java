package org.abhishek.hibernate;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest1 {

	public static void main(String[] args) {
		
//		This class demonstrates the concepts of
//		1. creating a model class with @Entity
//		2. creating a session
//		3. saving objects to db
//		4. getting objects from db
//	    5. using the hbm2ddl.auto configuration
		
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("Address of first user");
		user.setDescription("description of user");
		user.setJoiningDate(new Date());
		
		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			session.close();
			
			user = null;
			session = sessionFactory.openSession();
			session.beginTransaction();
			user = (UserDetails) session.get(UserDetails.class, 1);
			
			System.out.println("user name retrieved is "+user.getUserName());
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
