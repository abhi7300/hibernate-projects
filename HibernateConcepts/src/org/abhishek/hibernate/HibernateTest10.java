package org.abhishek.hibernate;



import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest10 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. HQL usage - parameter binding method 1
		// 2. HQL usage - parameter binding method 2

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

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ parameter binding method 1~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			// while writing HQL the tables are referred using the Entity name
			// and the columns are referred using the variable name
			int userId = 3;
			String userName = "User 3";
			TypedQuery<UserDetails> query = (TypedQuery<UserDetails>) session.createQuery("select user from USER_DETAILS user where userId>? and userName =?");
			query.setParameter(0, userId);
			query.setParameter(1, userName);
			List<UserDetails> userList = query.getResultList();
			if(userList!=null && !userList.isEmpty()){
				for(UserDetails user:userList){
					System.out.println("UserName:"+user.getUserName());
					System.out.println("UserDescription:"+user.getDescription());
					System.out.println("UserAddress:"+user.getAddress());
					System.out.println("UserId:"+user.getUserId());
				}
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ parameter binding method 2~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			int userId2 = 4;
			String userName2 = "User 4";
			TypedQuery<UserDetails> query2 = (TypedQuery<UserDetails>) session.createQuery("select user from USER_DETAILS user where userId>:userId and userName =:userName");
			query2.setParameter("userId", userId2);
			query2.setParameter("userName", userName2);
			List<UserDetails> userList2 = query2.getResultList();
			if(userList2!=null && !userList2.isEmpty()){
				for(UserDetails user:userList2){
					System.out.println("UserName:"+user.getUserName());
					System.out.println("UserDescription:"+user.getDescription());
					System.out.println("UserAddress:"+user.getAddress());
					System.out.println("UserId:"+user.getUserId());
				}
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			
			
			

			session.getTransaction().commit();
			session.close();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
