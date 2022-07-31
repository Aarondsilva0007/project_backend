package com.lti.myproj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "newbank")
public class BankDetails {

	public BankDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "BANKID")
	@SequenceGenerator(name = "BANKID" , sequenceName = "BANK_ID_SEQ" , allocationSize = 1)
	@Column(name = "BANK_ACCOUNT_NO")
	private int accountNo;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;
	
	@Column(name = "EXISTING_ACCOUNT_No")
	private int existingAccountNo;
	
	@Column(name = "BALANCE")
	private int balance;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "IFSC_CODE")
	private String ifscCode;

	public BankDetails(int accountNo, String accountName, int existingAccountNo, int balance, String email,
			String ifscCode) {
		super();
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.existingAccountNo = existingAccountNo;
		this.balance = balance;
		this.email = email;
		this.ifscCode = ifscCode;
	}



	public int getExistingAccountNo() {
		return existingAccountNo;
	}



	public void setExistingAccountNo(int existingAccountNo) {
		this.existingAccountNo = existingAccountNo;
	}

	
	@Override
	public String toString() {
		return "BankDetails [accountNo=" + accountNo + ", accountName=" + accountName + ", existingAccountNo="
				+ existingAccountNo + ", balance=" + balance + ", email=" + email + ", ifscCode=" + ifscCode + "]";
	}



	public BankDetails(String accountName, int balance, String email, String ifscCode) {
		super();
		this.accountName = accountName;
		this.balance = balance;
		this.email = email;
		this.ifscCode = ifscCode;
	}



	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}


}
