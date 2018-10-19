package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecurityRealmpage {

	private WebElement usernameLinkTextWebElement;
	
	
	public Boolean hasUserBeenCreated(WebDriver driver, String usernameString) {	
		
		
		//WebElement element = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.linkTest("user/" + usernameString + "/")));
			
		
		try {
			usernameLinkTextWebElement = driver.findElement(By.linkText(usernameString));
			usernameLinkTextWebElement.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			
		} catch (Exception ex) {
			
		}
		return false;
	}
}
