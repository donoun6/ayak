package com.ayak.phms.membership;

public class User { //userServlet에서 클라이언트의 요청값을 받아와 여기에 저장
	private String userId;
	private String userPassWd;
	private String userName;
	private String dateOfBirth;
	private String userGender;
	private String userEmail;
	private String userphone;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPassWd() {
		return userPassWd;
	}
	public void setUserPassWd(String userPassWd) {
		this.userPassWd = userPassWd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	
	
}
