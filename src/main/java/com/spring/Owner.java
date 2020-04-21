package com.spring;

public class Owner {
    private String name;
	private String password;
	private String mobileNumber;
	private String emailId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Owner() {}
	
	public Owner(String name,String password,String mobilenumber,String emailid) {
		this.name = name;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
	}

}
