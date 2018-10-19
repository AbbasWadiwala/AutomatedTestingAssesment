package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {

	@FindBy(xpath="//*[@id=\"j_username\"]")
	private  WebElement usernameTextFieldWebElement;

	@FindBy(xpath="/html/body/div/div/form/div[2]/input")
	private  WebElement passwordTextFieldWebElement;
	
	@FindBy(xpath="/html/body/div/div/form/div[3]/input")
	private  WebElement signInButtonWebElement;
	
	
	public void adminLogin() {
		usernameTextFieldWebElement.clear();
		usernameTextFieldWebElement.sendKeys(Constants.AdminUsername);
		passwordTextFieldWebElement.clear();
		passwordTextFieldWebElement.sendKeys(Constants.AdminPassword);
		signInButtonWebElement.click();
	}
}
