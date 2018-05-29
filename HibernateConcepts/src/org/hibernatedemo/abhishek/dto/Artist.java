package org.hibernatedemo.abhishek.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Artist {

	@Id @GeneratedValue
	private int id;
	@Column(name="ARTIST_ROLE")
	private String artistRole;
	@Column(name="ARTIST_NAME")
	private String artistName;
	@ManyToMany(mappedBy="artistList")
	private Collection<Agent> agentList = new ArrayList<Agent>();
	@OneToMany(mappedBy="artist", cascade=CascadeType.PERSIST)
	private Collection<VanityVan> vanList = new ArrayList<VanityVan>();

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

	/**
	 * @return the artistRole
	 */
	public String getArtistRole() {
		return artistRole;
	}

	/**
	 * @param artistRole the artistRole to set
	 */
	public void setArtistRole(String artistRole) {
		this.artistRole = artistRole;
	}

	/**
	 * @return the artistName
	 */
	public String getArtistName() {
		return artistName;
	}

	/**
	 * @param artistName the artistName to set
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * @return the agentList
	 */
	public Collection<Agent> getAgentList() {
		return agentList;
	}

	/**
	 * @param agentList the agentList to set
	 */
	public void setAgentList(Collection<Agent> agentList) {
		this.agentList = agentList;
	}

	/**
	 * @return the vanList
	 */
	public Collection<VanityVan> getVanList() {
		return vanList;
	}

	/**
	 * @param vanList the vanList to set
	 */
	public void setVanList(Collection<VanityVan> vanList) {
		this.vanList = vanList;
	}
	
}
