package org.abhishek.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest12 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Criteria Queries with Restrictions - EQUALS (Depricated) 
		// 2. Criteria Queries with Restrictions - OR (Depricated)
		// 3. Criteria Queries with Restrictions - LIKE (Depricated)
		// 4. Typed criteria queries (New from Hibernate 5.2) - Specifies the type of query results in advance

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


			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Deprecated Criteria Queries Example 1 ~~~~~~~~~~~~~~~~~~~~~~");

			
			Criteria criteria = session.createCriteria(UserDetails.class).add(Restrictions.eq("userName", "User 4"));
			List<UserDetails> userList3 = criteria.list();
			if (userList3 != null && !userList3.isEmpty()) {
				for (UserDetails user : userList3) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}
			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Deprecated Criteria Queries Example 2 ~~~~~~~~~~~~~~~~~~~~~~");

			
			Criteria criteria2 = session.createCriteria(UserDetails.class)
					            .add(Restrictions.or(Restrictions.eq("userName", "User 6"), Restrictions.eq("userName", "User 7")));
			List<UserDetails> userList4 = criteria2.list();
			if (userList4 != null && !userList4.isEmpty()) {
				for (UserDetails user : userList4) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}
			
			
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Deprecated Criteria Queries Example 3 ~~~~~~~~~~~~~~~~~~~~~~");

			
			Criteria criteria3 = session.createCriteria(UserDetails.class)
					            .add(Restrictions.or(Restrictions.like("userName", "% 6")));
			List<UserDetails> userList5 = criteria3.list();
			if (userList5 != null && !userList5.isEmpty()) {
				for (UserDetails user : userList5) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}

			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Criteria Queries Example ~~~~~~~~~~~~~~~~~~~~~~");
			
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<UserDetails> criteriaQuery = criteriaBuilder.createQuery(UserDetails.class);
			Root<UserDetails> root = criteriaQuery.from(UserDetails.class);
			criteriaQuery.select(root);
			criteriaQuery.where(criteriaBuilder.equal(root.get("userName"), "User 9"));
			List<UserDetails> userList6 = session.createQuery(criteriaQuery).getResultList(); 
			
			if (userList6 != null && !userList6.isEmpty()) {
				for (UserDetails user : userList6) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}

			session.getTransaction().commit();
			session.close();
			

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
