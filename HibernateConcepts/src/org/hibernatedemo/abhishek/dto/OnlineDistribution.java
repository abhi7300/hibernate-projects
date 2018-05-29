package org.hibernatedemo.abhishek.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Web") 
public class OnlineDistribution extends DistributionMedium{

	private String streamingPartner;
	private String subscriberBase;
	
	
	public String getStreamingPartner() {
		return streamingPartner;
	}
	public void setStreamingPartner(String streamingPartner) {
		this.streamingPartner = streamingPartner;
	}
	public String getSubscriberBase() {
		return subscriberBase;
	}
	public void setSubscriberBase(String subscriberBase) {
		this.subscriberBase = subscriberBase;
	}
	
	
}
