package com.lti.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LTI_identity_details")
public class IdentityDetails {

	public IdentityDetails() {
		super();
	}

	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BANKID")
	// @SequenceGenerator(name = "BANKID" , sequenceName = "BANK_ID_SEQ" ,
	// allocationSize = 1)

	@Column(name = "AADHAR_NO")
	private int aadharNumber;

	@Column(name = "PAN_NO")
	private String panNumber;

	public IdentityDetails(int aadharNumber, String panNumber) {
		super();
		this.aadharNumber = aadharNumber;
		this.panNumber = panNumber;

	}

	public int getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(int aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

}
