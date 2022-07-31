package com.lti.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.*;

import com.lti.myproj.model.User;

@Entity
@Table(name = "LTI_personal_details")
public class PersonalDetails {

	public PersonalDetails() {
		super();
	}

	// @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BANKID")
	// @SequenceGenerator(name = "BANKID" , sequenceName = "BANK_ID_SEQ" ,
	// allocationSize = 1)
	@Id
	@Column()
	private int customerId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "AGE")
	private int age;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE")
	private String state;

	@MapsId
	@OneToOne
	// @JoinColumn(name = "Customer_id", nullable = false)
	private User user;

	public PersonalDetails(String firstName, int age, String gender, String email, String mobile,
			String city, String state) {
		super();
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.mobile = mobile;
		this.city = city;
		this.state = state;
	}

	public void update(PersonalDetails personalDetails) {
		this.firstName = personalDetails.firstName;
		this.age = personalDetails.age;
		this.gender = personalDetails.gender;
		this.email = personalDetails.email;
		this.mobile = personalDetails.mobile;
		this.city = personalDetails.city;
		this.state = personalDetails.state;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int detailsId) {
		this.customerId = detailsId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
