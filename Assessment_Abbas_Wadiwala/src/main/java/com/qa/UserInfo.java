package com.qa;

public class UserInfo {
	
	public static String UserName = "xegro";
	public static String Password = UserName + "pass";
	public static String ConfirmPassword = UserName + "pass";
	public static String FullName = "abbas_wadiwala";
	public static String Email = UserName +"@gmail.com";
	
	public static String getUserFullUserInfoAsString() {
		return "UserName: " + UserName + ", Password: " + Password + ", Full Name: " + 
				FullName +  ", Email: " + Email;
	}
	
	public static void setUserFullUserInfo(String userName, String password, String confirmPassword, String fullName, String email) {
		
		UserName = userName;
		Password = password;
		ConfirmPassword = confirmPassword;
		FullName = fullName;
		Email = email;
		
	}
}
