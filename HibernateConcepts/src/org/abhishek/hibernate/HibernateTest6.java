package org.abhishek.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.Artist;
import org.hibernatedemo.abhishek.dto.VanityVan;

public class HibernateTest6 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. Cascading

		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Artist artist1 = new Artist();
			artist1.setArtistName("Artist 3");
			artist1.setArtistRole("Actor");

			VanityVan vanityVan = new VanityVan();
			vanityVan.setArtist(artist1);
			vanityVan.setVanName("Cool Van");
			artist1.getVanList().add(vanityVan);

			session.persist(artist1);
			// as the VanityVan - Artist object mapping cascading type has been
			// made PERSIST, now we do not have to save the VanityVan object
			// separately.
			// Now saving the Artist object saves the VanityVan object as well.
			// CascadeType has multiple other values.
			
			//ALL,PERSIST,MERGE,REFRESH,RELOAD,DETACH,REMOVE

			session.getTransaction().commit();
			session.close();

		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
