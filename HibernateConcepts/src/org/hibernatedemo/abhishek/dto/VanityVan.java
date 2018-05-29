package org.hibernatedemo.abhishek.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VanityVan {

	@Id @GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="VAN_NAME")
	private String vanName;
	@ManyToOne
	@JoinColumn(name="ARTIST_ID")
	private Artist artist;
	
	
	
	/**
	 * @return the vanName
	 */
	public String getVanName() {
		return vanName;
	}
	/**
	 * @param vanName the vanName to set
	 */
	public void setVanName(String vanName) {
		this.vanName = vanName;
	}
	/**
	 * @return the artist
	 */
	public Artist getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
