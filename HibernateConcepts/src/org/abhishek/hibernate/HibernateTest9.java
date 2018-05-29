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

public class HibernateTest9 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. HQL usage - getting objects
		// 2. HQL usage - pagination
		// 3. HQL usage - using the select keyword
		// 4. HQL usage - using hql functions such as map

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

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			// while writing HQL the tables are referred using the Entity name
			// and the columns are referred using the variable name
			TypedQuery<UserDetails> query = (TypedQuery<UserDetails>) session.createQuery("select user from USER_DETAILS user where userId>50");
			List<UserDetails> userList = query.getResultList();
			if(userList!=null && !userList.isEmpty()){
				for(UserDetails user:userList){
					System.out.println("UserName:"+user.getUserName());
					System.out.println("UserDescription:"+user.getDescription());
					System.out.println("UserAddress:"+user.getAddress());
					System.out.println("UserId:"+user.getUserId());
				}
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			TypedQuery<UserDetails> paginationQuery = session.createQuery("from USER_DETAILS", UserDetails.class);
			paginationQuery.setFirstResult(5);
			paginationQuery.setMaxResults(2);
			List<UserDetails> userList2 = paginationQuery.getResultList();
			if(userList2!=null && !userList2.isEmpty()){
				for(UserDetails user:userList2){
					System.out.println("UserName:"+user.getUserName());
					System.out.println("UserDescription:"+user.getDescription());
					System.out.println("UserAddress:"+user.getAddress());
					System.out.println("UserId:"+user.getUserId());
				}
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			
			TypedQuery<String> query3 = session.createQuery("select user.userName from USER_DETAILS user", String.class);
			
			List<String> userNameList = query3.getResultList();
			if(userNameList!=null && !userNameList.isEmpty()){
				for(String name:userNameList){
					System.out.println("UserName:"+name);
				}
			}
			
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			
			TypedQuery<Map> query4 = session.createQuery("select new map(userId,userName,address) from USER_DETAILS user", Map.class);
			
			List<Map> mapList = query4.getResultList();
			if(mapList!=null && !mapList.isEmpty()){
				for(Map map:mapList){
					Set keys = map.keySet();
					Integer userId = (Integer) map.get("0");
					String userName = (String) map.get("1");
					String userAddress = (String) map.get("2");
					System.out.println("userId: "+userId+", userName: "+userName+", userAddress: "+userAddress);
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
