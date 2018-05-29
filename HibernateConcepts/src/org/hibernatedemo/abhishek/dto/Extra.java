package org.hibernatedemo.abhishek.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Extra {

	@Column(name="EXTRA_NAME")
	private String extraName;
	@Column(name="EXTRA_AGE")
	private String extraAge;
	@Column(name="EXTRA_WAGE")
	private int extraWage;
	
	
	public String getExtraName() {
		return extraName;
	}
	public void setExtraName(String extraName) {
		this.extraName = extraName;
	}
	public String getExtraAge() {
		return extraAge;
	}
	public void setExtraAge(String extraAge) {
		this.extraAge = extraAge;
	}
	public int getExtraWage() {
		return extraWage;
	}
	public void setExtraWage(int extraWage) {
		this.extraWage = extraWage;
	}
	
	
	
}
