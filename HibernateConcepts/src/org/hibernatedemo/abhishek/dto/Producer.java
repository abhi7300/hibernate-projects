package org.hibernatedemo.abhishek.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Producer {

	@Column(name="PRODUCER_NAME")
	private String producerName;
	@Column(name="PRODUCER_AGE")
	private String producerAge;
	
	
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	public String getProducerAge() {
		return producerAge;
	}
	public void setProducerAge(String producerAge) {
		this.producerAge = producerAge;
	}
	
	
}
