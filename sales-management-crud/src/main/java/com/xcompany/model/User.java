package com.xcompany.model;

public class User {

	private int userId;
	private String userUsername, userPassword, userFirstName, userLastName;
	
	public User() {}
	
	public User(int userId, String userEmail, String userPassword, String userFirstName, String userLastName) {
		super();
		this.userId = userId;
		this.userUsername = userEmail;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userUsername;
	}
	public void setUserEmail(String userEmail) {
		this.userUsername = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userUsername + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + "]";
	}
		
}
