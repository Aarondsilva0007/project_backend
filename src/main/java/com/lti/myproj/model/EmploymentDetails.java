package com.lti.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.MapsId;

import com.lti.myproj.model.User;

@Entity
@Table(name = "LTI_employment_details")
public class EmploymentDetails {

	public EmploymentDetails() {
		super();
	}

	@Id
	private int customerId;

	@Column(name = "TYPE_OF_EMPLOYMENT")
	private String typeOfEmployment;

	@Column(name = "ANNUAL_SALARY")
	private int annualSalary;

	@Column(name = "EXISTING_EMI")
	private String existingEmi;

	@MapsId
	@OneToOne
	private User user;

	public EmploymentDetails(String typeOfEmployment, int annualSalary, String existingEmi) {
		super();
		this.typeOfEmployment = typeOfEmployment;
		this.annualSalary = annualSalary;
		this.existingEmi = existingEmi;

	}

	public void update(EmploymentDetails employmentDetails) {
		this.typeOfEmployment = employmentDetails.typeOfEmployment;
		this.annualSalary = employmentDetails.annualSalary;
		this.existingEmi = employmentDetails.existingEmi;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getTypeOfEmployment() {
		return typeOfEmployment;
	}

	public void setTypeOfEmployment(String typeOfEmployment) {
		this.typeOfEmployment = typeOfEmployment;
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualsalary(int annualSalary) {
		this.annualSalary = annualSalary;
	}

	public String getExistingEmi() {
		return existingEmi;
	}

	public void setExistingEmi(String existingEmi) {
		this.existingEmi = existingEmi;
	}

}
