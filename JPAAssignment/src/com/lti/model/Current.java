package com.lti.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="current")
public class Current extends Account{
	private double overdraf;

	public Current() {
		super();
		
	}

	public Current(long accountNumber, String accountHolderName, double accountBalance, double overdradf) {
		super(accountNumber, accountHolderName, accountBalance);
		this.overdraf=overdradf;
	}

	public double getOverdraf() {
		return overdraf;
	}

	public void setOverdraf(double overdraf) {
		this.overdraf = overdraf;
	}

	@Override
	public String toString() {
		return "Current [overdraf=" + overdraf + ", toString()=" + super.toString() + "]";
	}

	
	

	
	
}
