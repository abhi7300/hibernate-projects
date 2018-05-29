package org.hibernatedemo.abhishek.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PremiereDetails {

	@Id @GeneratedValue
	private int Id;
	@Column(name="PREMIERE_DATE")
	@Temporal(TemporalType.DATE)
	private Date premiereDate;
	@Column(name="PREMIERE_VENUE")
	private String premiereVenue;
	@OneToOne(mappedBy="premiereDetails")
	private Movie movie;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the premiereVenue
	 */
	public String getPremiereVenue() {
		return premiereVenue;
	}
	/**
	 * @param premiereVenue the premiereVenue to set
	 */
	public void setPremiereVenue(String premiereVenue) {
		this.premiereVenue = premiereVenue;
	}
	/**
	 * @return the premiereDate
	 */
	public Date getPremiereDate() {
		return premiereDate;
	}
	/**
	 * @param premiereDate the premiereDate to set
	 */
	public void setPremiereDate(Date premiereDate) {
		this.premiereDate = premiereDate;
	}
	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return movie;
	}
	/**
	 * @param movie the movie to set
	 */
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
}
