package org.abhishek.hibernate;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.UserDetails;

public class HibernateTest15 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Hibernate L2 Cache in action.
		// 2. Hibernate Query Cache in action.
		
		
		// In order to enable second level cache in Hibernate 5.2 follow the following steps
		// 1. Provide the following configurations in hibernate.cfg.xml:
		//  <property name="hibernate.cache.use_second_level_cache">true</property>
        //  <property name="hibernate.cache.region.factory_class">org.hibernate.cache.ehcache.EhCacheRegionFactory</property>
		// 2. Include the EhCache Jar files provided as part of the Hibernate distribution, in the library.
		// 3. Mark the Entity to be cached as @Cacheble
		// 4. (Optional) Specify the Caching strategy using the @Cache annotation in the Entity class.
	    // Note: Query cache (using cache when executing HQL) is not enabled by default. To enable query cache,  Provide the 
		//       following configuration in hibernate.cfg.xml
		//  <property name="hibernate.cache.use_query_cache">true</property> , and
		//  set query.setCacheable(true); for ALL the queries which must be cached.
		// (query.setHint("org.hibernate.cacheable", true); Hibernate 5.x Onwards).

		try {

			
			
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~ Second Level Cache Enabled - HQL will be printed ~~~~~~~~~~~~~~~~~~~~~~");

			UserDetails user = session.get(UserDetails.class, 53);
			System.out.println("UserName:" + user.getUserName());
			System.out.println("UserDescription:" + user.getDescription());
			System.out.println("UserAddress:" + user.getAddress());
			System.out.println("UserId:" + user.getUserId());
			
			session.getTransaction().commit();
			session.close();
			
			
			
			
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~ Second Level Cache Enabled - HQL will not be printed (no trip to db) ~~~~~~~~~~~~~~~~~~~~~~");
			
			// As this is a new session, the cache is different. 
			// Now, even though the query is same, a trip to the db will be made,
			
			Session session2 = sessionFactory.openSession();
			session2.beginTransaction();
			
			UserDetails user3 = session2.get(UserDetails.class, 53);
			System.out.println("UserName:" + user3.getUserName());
			System.out.println("UserDescription:" + user3.getDescription());
			System.out.println("UserAddress:" + user3.getAddress());
			System.out.println("UserId:" + user3.getUserId());
			
			session2.getTransaction().commit();
			session2.close();
			
			
			
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~ Query Cache Enabled - HQL will be printed ~~~~~~~~~~~~~~~~~~~~~~");
			
			Session session3 = sessionFactory.openSession();
			session3.beginTransaction();
			
			TypedQuery<UserDetails> query1 = (TypedQuery<UserDetails>) session3.createQuery("select user from USER_DETAILS user where userName ='User 8'");
			query1.setHint("org.hibernate.cacheable", true);
			List<UserDetails> userList1 = query1.getResultList();
			if(userList1!=null && !userList1.isEmpty()){
				for(UserDetails user1:userList1){
					System.out.println("UserName:"+user1.getUserName());
					System.out.println("UserDescription:"+user1.getDescription());
					System.out.println("UserAddress:"+user1.getAddress());
					System.out.println("UserId:"+user1.getUserId());
				}
			}
			
			session3.getTransaction().commit();
			session3.close();
			
			
			
			System.out.println(
					"~~~~~~~~~~~~~~~~~~~~~~ Query Cache Enabled - HQL will not be printed (no trip to db) ~~~~~~~~~~~~~~~~~~~~~~");
			
			
			Session session4 = sessionFactory.openSession();
			session4.beginTransaction();
			

			TypedQuery<UserDetails> query2 = (TypedQuery<UserDetails>) session4.createQuery("select user from USER_DETAILS user where userName ='User 8'");
			query2.setHint("org.hibernate.cacheable", true);
			List<UserDetails> userList2 = query2.getResultList();
			if(userList2!=null && !userList2.isEmpty()){
				for(UserDetails user2:userList2){
					System.out.println("UserName:"+user2.getUserName());
					System.out.println("UserDescription:"+user2.getDescription());
					System.out.println("UserAddress:"+user2.getAddress());
					System.out.println("UserId:"+user2.getUserId());
				}
			}
			
			session4.getTransaction().commit();
			session4.close();
			
			

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
