package org.hibernatedemo.abhishek.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Agent {

	@Id @GeneratedValue
	private int id;
	@Column(name="AGENT_ID_CODE")
	private String agentIdCode;
	@Column(name="AGENT_NAME")
	private String agentName;
	@ManyToMany
	@JoinTable(name="AGENT_ARTIST_MAP",joinColumns=@JoinColumn(name="AGENT_ID"),inverseJoinColumns=@JoinColumn(name="ARTIST_ID"))
	private Collection<Artist> artistList = new ArrayList<Artist>(); 
	
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
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	 * @return the artistList
	 */
	public Collection<Artist> getArtistList() {
		return artistList;
	}
	/**
	 * @param artistList the artistList to set
	 */
	public void setArtistList(Collection<Artist> artistList) {
		this.artistList = artistList;
	}
	/**
	 * @return the agentIdCode
	 */
	public String getAgentIdCode() {
		return agentIdCode;
	}
	/**
	 * @param agentIdCode the agentIdCode to set
	 */
	public void setAgentIdCode(String agentIdCode) {
		this.agentIdCode = agentIdCode;
	}
	
	
}
