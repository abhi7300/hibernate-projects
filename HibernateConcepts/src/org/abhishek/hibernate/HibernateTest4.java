package org.abhishek.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.Movie;
import org.hibernatedemo.abhishek.dto.PremiereDetails;

public class HibernateTest4 {

	public static void main(String[] args) {
//		This class demonstrates the concepts of
//		1. OneToOne mappings
//		2. usage of mappedBy attribute for OneToOne mappings

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Movie movie = (Movie) session.get(Movie.class, 1);

		if (movie != null) {

			PremiereDetails premiereDetails = new PremiereDetails();
			premiereDetails.setMovie(movie);
			movie.setPremiereDetails(premiereDetails);
			premiereDetails.setPremiereDate(new Date());
			premiereDetails.setPremiereVenue("Basushri Cinema");
			
			session.update(movie);
			session.save(premiereDetails);
		}

		session.getTransaction().commit();
		session.close();

	}

}
