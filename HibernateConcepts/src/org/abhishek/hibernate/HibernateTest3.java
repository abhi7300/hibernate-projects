package org.abhishek.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.Awards;
import org.hibernatedemo.abhishek.dto.Movie;

public class HibernateTest3 {

	public static void main(String[] args) {
		
//		This class demonstrates the concepts of
//		1. OneToMany and ManyToOne mappings
//		2. usage of mappedBy attribute

		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			Movie theDarkKnight = (Movie) session.get(Movie.class, 1);
			
			//to demonstrate @OneToMany 
			Awards award1=new Awards();
			award1.setAwardName("Golden Globe");
			
			Awards award2=new Awards();
			award2.setAwardName("BAFTA");
			
			theDarkKnight.getAwardsList().add(award1);
			theDarkKnight.getAwardsList().add(award2);
			
			
			award1.setMovie(theDarkKnight);
			award2.setMovie(theDarkKnight);
			
			session.save(theDarkKnight);
			session.save(award1);
			session.save(award2);
			
			
			//to demonstrate @OneToMany 
			
			session.getTransaction().commit();
			session.close();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
