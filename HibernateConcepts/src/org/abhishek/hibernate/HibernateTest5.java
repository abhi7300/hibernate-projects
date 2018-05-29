package org.abhishek.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.Agent;
import org.hibernatedemo.abhishek.dto.Artist;

public class HibernateTest5 {

	public static void main(String[] args) {
		// This class demonstrates the concepts of
		// 1. ManyToMany mapping

		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			Agent agent1=new Agent();
			agent1.setAgentName("Agent 1");
			agent1.setAgentIdCode("AGENT/A/1");
			
			Agent agent2=new Agent();
			agent2.setAgentName("Agent 2");
			agent2.setAgentIdCode("AGENT/A/2");
			
			Artist artist1 = new Artist();
			artist1.setArtistName("Artist 1");
			artist1.setArtistRole("Actor");
			
			Artist artist2 = new Artist();
			artist2.setArtistName("Artist 2");
			artist2.setArtistRole("Actor");
			
			agent1.getArtistList().add(artist1);
			agent1.getArtistList().add(artist2);
			
			agent2.getArtistList().add(artist1);
			agent2.getArtistList().add(artist2);
			
			artist1.getAgentList().add(agent1);
			artist1.getAgentList().add(agent2);
			
			artist2.getAgentList().add(agent1);
			artist2.getAgentList().add(agent2);
			
			session.save(artist1);
			session.save(artist2);
			session.save(agent1);
			session.save(agent2);
			
			
			
			session.getTransaction().commit();
			session.close();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
