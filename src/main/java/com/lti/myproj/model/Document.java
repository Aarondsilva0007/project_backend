package com.lti.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LTI_Document")
public class Document {

	@Id
	@Column()
	private int customerId;

	@Column(name = "AADHAR_URL")
	private String aadhar;

	@Column(name = "PAN_URL")
	private String pan;

	@Column(name = "IMAGE_URL")
	private String image;

	@Column(name = "SALARYSLIP_URL")
	private String salary_slip;

	@MapsId
	@OneToOne
	// @JoinColumn(name = "Customer_id", nullable = false)
	private User user;

	public Document() {
		super();
	}

	public Document(String aadhar, String pan, String image, String salary_slip) {
		super();
		this.aadhar = aadhar;
		this.pan = pan;
		this.image = image;
		this.salary_slip = salary_slip;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSalary_slip() {
		return salary_slip;
	}

	public void setSalary_slip(String salary_slip) {
		this.salary_slip = salary_slip;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public void update(Document documents) {
		this.aadhar = documents.aadhar;
		this.pan = documents.aadhar;
		this.image = documents.image;
		this.salary_slip = documents.salary_slip;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
