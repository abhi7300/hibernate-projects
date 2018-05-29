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
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest13 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Criteria Queries Projections Example 1 (Depricated) 
		// 2. Criteria Queries Projections Example 2 (Depricated)
		// 3. Query By Example
		// 4. Query By Example - EnableLike
		// 5. Criteria Query Example - Order By

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


			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Deprecated Criteria Queries Projections Example 1 ~~~~~~~~~~~~~~~~~~~~~~");

			
			Criteria criteria = session.createCriteria(UserDetails.class)
					.setProjection(Projections.property("userName"));
			List<String> userNameList = criteria.list();
			
			if (userNameList != null && !userNameList.isEmpty()) {
				for (String userName : userNameList) {
					System.out.println("UserName: " + userName);
				}
			}
			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Deprecated Criteria Queries Projections Example 2 ~~~~~~~~~~~~~~~~~~~~~~");

			
			Criteria criteria2 = session.createCriteria(UserDetails.class)
					.setProjection(Projections.max("userId"));
			List<Integer> userIdList = criteria2.list();
			
			if (userIdList != null && !userIdList.isEmpty()) {
				for (Integer userId : userIdList) {
					System.out.println("UserId: " + userId);
				}
			}
			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Criteria Query By Example Part 1 ~~~~~~~~~~~~~~~~~~~~~~");

			UserDetails exampleUser = new UserDetails();
			exampleUser.setUserName("User 8");
			
			Example exampleObj = Example.create(exampleUser);
			
			Criteria criteria3 = session.createCriteria(UserDetails.class)
					            .add(exampleObj);
			List<UserDetails> userList5 = criteria3.list();
			if (userList5 != null && !userList5.isEmpty()) {
				for (UserDetails user : userList5) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}

			
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Criteria Query By Example (Enable Like) ~~~~~~~~~~~~~~~~~~~~~~");
			
			

			UserDetails exampleUser2 = new UserDetails();
			exampleUser2.setUserName("% 9");
			
			// This line is the key one.
			Example exampleObj2 = Example.create(exampleUser2).enableLike();
			
			Criteria criteria4 = session.createCriteria(UserDetails.class)
					            .add(exampleObj2);
			List<UserDetails> userList6 = criteria4.list();
			if (userList6 != null && !userList6.isEmpty()) {
				for (UserDetails user : userList6) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}
			
			
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~ Criteria Queries Example - Order By ~~~~~~~~~~~~~~~~~~~~~~");
			
			

			
			Criteria criteria5 = session.createCriteria(UserDetails.class)
					            .add(Restrictions.like("userName", "User %"))
					            .addOrder(Order.desc("userId"));
			List<UserDetails> userList7 = criteria5.list();
			if (userList7 != null && !userList7.isEmpty()) {
				for (UserDetails user : userList7) {
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
