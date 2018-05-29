package org.hibernatedemo.abhishek.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity	
public class Awards {

	@Id @GeneratedValue
	@Column(name="AWARD_ID")
	private int id;
	
	@Column(name="AWARD_NAME")
	private String awardName;
	
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
	private Movie movie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAwardName() {
		return awardName;
	}
	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
