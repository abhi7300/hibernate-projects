package org.abhishek.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernatedemo.abhishek.dto.Actor;
import org.hibernatedemo.abhishek.dto.Extra;
import org.hibernatedemo.abhishek.dto.Movie;
import org.hibernatedemo.abhishek.dto.Producer;

public class HibernateTest2 {

	public static void main(String[] args) {
//		This class demonstrates the concepts of
//		1. embedding objects in an object using @Embeddable and @Embedded
//      2. overriding the embedded object's column names using @AttributeOverrides and @AttributeOverride
//		3. embedding collections in an object using @ElementCollection
//		4. generating the id automatically using @GeneratedValue and strategy attribute
//		5. automatic foreign key creation in movie_actorList table which will be primary key of movie.
		
		Movie movie = new Movie();
		movie.setMovieName("The Dark Knight");
		movie.setDirectorName("Cristopher Nolan");
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//to illustrate the concept of not using @JoinTable and @JoinColumn together
		Actor batmanActor = new Actor();
		batmanActor.setActorName("Cristian Bale");
		batmanActor.setActorAge("40");
		batmanActor.setActorWage(20000000);
		
		Actor jokerActor = new Actor();
		jokerActor.setActorName("Heath Ledger");
		jokerActor.setActorAge("41");
		jokerActor.setActorWage(21000000);
		
		movie.getActorList().add(batmanActor);
		movie.getActorList().add(jokerActor);
		//to illustrate the concept of not using @JoinTable and @JoinColumn together
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//to illustrate the concept of @AttributeOverride(s) in case of an Embedded value object
		Producer producer = new Producer();
		producer.setProducerName("Cristopher Nolan");
		producer.setProducerAge("44");
		
		movie.setProducer(producer);
		
		Producer executiveProducer = new Producer();
		executiveProducer.setProducerName("Emma Thomas");
		executiveProducer.setProducerAge("40");
		
		movie.setExecutiveProducer(executiveProducer);
		//to illustrate the concept of @AttributeOverride(s) in case of an Embedded value object
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		//to illustrate the concept of @JoinTable and @JoinColumn together
		Extra movieExtra1=new Extra();
		movieExtra1.setExtraName("Extra 1");
		movieExtra1.setExtraAge("2");
		movieExtra1.setExtraWage(10000);
		
		Extra movieExtra2=new Extra();
		movieExtra2.setExtraName("Extra 2");
		movieExtra2.setExtraAge("2");
		movieExtra2.setExtraWage(20000);
		
		movie.getExtraList().add(movieExtra1);
		movie.getExtraList().add(movieExtra2);
		
		//to illustrate the concept of @JoinTable and @JoinColumn together
		
		//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		try {
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(movie);
			session.getTransaction().commit();
			session.close();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
