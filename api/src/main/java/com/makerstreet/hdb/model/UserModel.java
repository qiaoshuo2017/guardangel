package com.makerstreet.hdb.model;
/*
 * 对应数据库用户表的javabean模型
 */
public class UserModel {
	private int UserId;
	private String userName;
	private String NickName;
	private String UserType;
	private String mobilePhone;
	private String RegisterIP;
	private double RegisterLocLng;
	private double RegisterLocLat;
	private String Password;
	private String UserRole;
	private String SessionToken;
	private String SessionTime;
	private int FailureCount;
	private String LastLoginTime;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getRegisterIP() {
		return RegisterIP;
	}
	public void setRegisterIP(String registerIP) {
		RegisterIP = registerIP;
	}
	public double getRegisterLocLng() {
		return RegisterLocLng;
	}
	public void setRegisterLocLng(double registerLocLng) {
		RegisterLocLng = registerLocLng;
	}
	public double getRegisterLocLat() {
		return RegisterLocLat;
	}
	public void setRegisterLocLat(double registerLocLat) {
		RegisterLocLat = registerLocLat;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	public String getSessionToken() {
		return SessionToken;
	}
	public void setSessionToken(String sessionToken) {
		SessionToken = sessionToken;
	}
	public String getSessionTime() {
		return SessionTime;
	}
	public void setSessionTime(String sessionTime) {
		SessionTime = sessionTime;
	}
	public int getFailureCount() {
		return FailureCount;
	}
	public void setFailureCount(int failureCount) {
		FailureCount = failureCount;
	}
	public String getLastLoginTime() {
		return LastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		LastLoginTime = lastLoginTime;
	}
}