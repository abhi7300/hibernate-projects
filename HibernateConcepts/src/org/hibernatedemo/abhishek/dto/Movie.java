package org.hibernatedemo.abhishek.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "MOVIE_NAME")
	private String movieName;
	@Column(name = "DIRECTOR_NAME")
	private String directorName;
	
	@Embedded
	private Producer producer;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "producerName", column = @Column(name = "EXEC_PRODUCER_NAME")),
			@AttributeOverride(name = "producerAge", column = @Column(name = "EXEC_PRODUCER_AGE")) })
	private Producer executiveProducer;
	
	
	@ElementCollection
	private Set<Actor> actorList = new HashSet<Actor>();

	@ElementCollection
	@JoinTable(name = "MOVIE_EXTRAS", joinColumns = @JoinColumn(name = "MOVIE_ID"))
	private Set<Extra> extraList = new HashSet<Extra>();

	//@OneToMany without using mappedBy attribute
	@OneToMany(mappedBy="movie")
//	@JoinTable(name="MOVIE_AWARDS", joinColumns=@JoinColumn(name="MOVIE_ID"),
//	          inverseJoinColumns=@JoinColumn(name="AWARD_ID"))
	private Collection<Awards> awardsList = new ArrayList<Awards>(); 
	

	@JoinColumn(name="PREMIERE_DETAILS_ID")
	@OneToOne
	private PremiereDetails premiereDetails;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Set<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(Set<Actor> actorList) {
		this.actorList = actorList;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Producer getExecutiveProducer() {
		return executiveProducer;
	}

	public void setExecutiveProducer(Producer executiveProducer) {
		this.executiveProducer = executiveProducer;
	}

	public Set<Extra> getExtraList() {
		return extraList;
	}

	public void setExtraList(Set<Extra> extraList) {
		this.extraList = extraList;
	}

	public Collection<Awards> getAwardsList() {
		return awardsList;
	}

	public void setAwardsList(Collection<Awards> awardsList) {
		this.awardsList = awardsList;
	}

	/**
	 * @return the premiereDetails
	 */
	public PremiereDetails getPremiereDetails() {
		return premiereDetails;
	}

	/**
	 * @param premiereDetails the premiereDetails to set
	 */
	public void setPremiereDetails(PremiereDetails premiereDetails) {
		this.premiereDetails = premiereDetails;
	}

}
