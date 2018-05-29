package org.hibernatedemo.abhishek.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Actor {

	@Column(name="ACTOR_NAME")
	private String actorName;
	@Column(name="ACTOR_AGE")
	private String actorAge;
	@Column(name="ACTOR_WAGE")
	private int actorWage;
	
	
	public String getActorName() {
		return actorName;
	}
	public void setActorName(String actorName) {
		this.actorName = actorName;
	}
	public String getActorAge() {
		return actorAge;
	}
	public void setActorAge(String actorAge) {
		this.actorAge = actorAge;
	}
	public int getActorWage() {
		return actorWage;
	}
	public void setActorWage(int actorWage) {
		this.actorWage = actorWage;
	}
	
	
}
