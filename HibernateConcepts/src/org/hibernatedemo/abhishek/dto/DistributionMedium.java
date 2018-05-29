package org.hibernatedemo.abhishek.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="DISTRIBUTION_MEDIUM")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DISTRIBUTION_TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("General") 
public class DistributionMedium {

	@Id @GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="RIGHTS_VALUE")
	private String rightsValue;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRightsValue() {
		return rightsValue;
	}
	public void setRightsValue(String rightsValue) {
		this.rightsValue = rightsValue;
	}
	
	
	
}
