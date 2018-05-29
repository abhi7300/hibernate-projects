package org.abhishek.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest14 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Hibernate L1 Cache in action

		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			/*
			 * for (int i = 1; i < 11; i++) { UserDetails user = new
			 * UserDetails(); user.setUserName("User " + i);
			 * user.setDescription("Description for User " + i);
			 * user.setJoiningDate(new Date());
			 * user.setAddress("Address For User " + i); session.save(user); }
			 */

			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			
			
			UserDetails user = session.get(UserDetails.class, 53);
			System.out.println("UserName:" + user.getUserName());
			System.out.println("UserDescription:" + user.getDescription());
			System.out.println("UserAddress:" + user.getAddress());
			System.out.println("UserId:" + user.getUserId());
			
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			// As the same data is fetched for the second time, it is being fetched from the session cache or the L1 cache.
			// Hibernate L1 cache works within a session, so no select hql statement is printed in console this time.
			// This only works if data is fetched this way without executing HQL through the session.
			
			UserDetails user2 = session.get(UserDetails.class, 53);
			System.out.println("UserName:" + user2.getUserName());
			System.out.println("UserDescription:" + user2.getDescription());
			System.out.println("UserAddress:" + user2.getAddress());
			System.out.println("UserId:" + user2.getUserId());

			session.getTransaction().commit();
			session.close();
			
			
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			SessionFactory sessionFactory2 = new Configuration().configure().buildSessionFactory();
			Session session2 = sessionFactory.openSession();
			session2.beginTransaction();
			
			// As this is a new session, the cache is different. 
			// Now, even though the query is same, a trip to the db will be made,
			
			UserDetails user3 = session2.get(UserDetails.class, 53);
			System.out.println("UserName:" + user3.getUserName());
			System.out.println("UserDescription:" + user3.getDescription());
			System.out.println("UserAddress:" + user3.getAddress());
			System.out.println("UserId:" + user3.getUserId());
			
			session2.getTransaction().commit();
			session2.close();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
