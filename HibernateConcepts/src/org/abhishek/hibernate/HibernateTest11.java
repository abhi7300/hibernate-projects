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
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest11 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. NamedQuery
		// 2. NamedNativeQuery

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

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Named query example ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			// while writing HQL the tables are referred using the Entity name
			// and the columns are referred using the variable name
			String userName = "User 3";
			TypedQuery<UserDetails> query = session.getNamedQuery("UserDetails.byUserName");
			query.setParameter(0, userName);
			List<UserDetails> userList = query.getResultList();
			if (userList != null && !userList.isEmpty()) {
				for (UserDetails user : userList) {
					System.out.println("UserName:" + user.getUserName());
					System.out.println("UserDescription:" + user.getDescription());
					System.out.println("UserAddress:" + user.getAddress());
					System.out.println("UserId:" + user.getUserId());
				}
			}

			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Named native query example ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			String userName2 = "User 4";
			TypedQuery<UserDetails> query2 = session.getNamedNativeQuery("UserDetails.native.byUserName");
			query2.setParameter(0, userName2);
			List<UserDetails> userList2 = query2.getResultList();
			if (userList2 != null && !userList2.isEmpty()) {
				for (UserDetails user : userList2) {
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
