package com.qa;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JenkinsDashBoardPage {
	
	@FindBy(xpath="//*[@id=\"tasks\"]/div[4]/a[2]")
	WebElement manageJenkinsLinkWebElement;
	
	
	public void goToManageJenkinsPage() {
		manageJenkinsLinkWebElement.click();
	}
}
