package com.qa;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	
	WebDriver driver = null;
	
	static ExtentReports extentReportRef = new ExtentReports(Constants.FilePath_TestReport + Constants.FileName_TestReport, Constants.ReplaceExistingBoolean);
	ExtentTest extentTestRef;
	CreateUserPage createUserPage;
	AdminLoginPage adminLoginpage;
	SecurityRealmpage securityRealmPage;
	
	public static int iTestCounter = 1;	
	
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		if(iTestCounter == 1) {
			// Initialise start the test
			extentTestRef = extentReportRef.startTest("Add a User to the database Without Parameterisation");
		}
		else if(iTestCounter > 1 && iTestCounter < 5 ) {
			// Initialise start the test
			extentTestRef = extentReportRef.startTest("Add a User to the database With Parameterisation");
		}
		
	}
	
	@After
	public void tearDown() {		
		extentReportRef.flush();	
	}

	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen() throws Throwable {
		
		driver = new ChromeDriver();	
		extentTestRef.log(LogStatus.INFO, "Browser started");	
		
		driver.manage().window().maximize();		
		extentTestRef.log(LogStatus.INFO, "Browser Window Maximised");	
		
		driver.get(Constants.AdminLoginPageURL);		
		adminLoginpage = PageFactory.initElements(driver, AdminLoginPage.class);
		adminLoginpage.adminLogin();		
		
		Thread.sleep(2000);
		driver.get(Constants.CreateUserPageURL);
		Thread.sleep(2000);
		extentTestRef.log(LogStatus.INFO, "Site Opened URL: " + Constants.CreateUserPageURL);
		
		String driverTitleString = driver.getTitle();
		extentTestRef.log(LogStatus.INFO, "Retrieved PageTitle: " + driverTitleString );	
		
		extentTestRef.log(LogStatus.INFO, "Comparing Page Title To Expected Page Title: " + Constants.CreateUserPageTitle);	
		if(!driverTitleString.equals(Constants.CreateUserPageTitle)) {		
	    	extentTestRef.log(LogStatus.FAIL, "Correct Page Was Not Loaded");
	    	extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
	    	driver.close();
	    }		
		assertEquals("Matching page title with what's expected", Constants.CreateUserPageTitle, driverTitleString);
		// report the test as a pass
		extentTestRef.log(LogStatus.PASS, "Correct Page Was Opened");		
		
		if(iTestCounter != 1) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
	    	driver.close();
		}
		
	}
	
	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen() throws Throwable {
		
		createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
		try {
			createUserPage.setUserInputByIndex(0, UserInfo.UserName);
			createUserPage.setUserInputByIndex(1, UserInfo.Password);
			createUserPage.setUserInputByIndex(2, UserInfo.ConfirmPassword);
			createUserPage.setUserInputByIndex(3, UserInfo.FullName);
			createUserPage.setUserInputByIndex(4, UserInfo.Email);
			extentTestRef.log(LogStatus.INFO, "Entered User Details:- " + UserInfo.getUserFullUserInfoAsString() );	
		}  catch (NoSuchElementException e) {
			extentTestRef.log(LogStatus.INFO, "Submit Was Not Found");	
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;			
		} catch(Exception ex) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}	
		
	}
	
	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen() throws Throwable {
		
		extentTestRef.log(LogStatus.INFO, "Attempting To Click Submit Button ");	
		try {
			createUserPage.submitUserDetails();
			extentTestRef.log(LogStatus.PASS, "Submit Button Clicked ");	
		} catch (NoSuchElementException e) {
			extentTestRef.log(LogStatus.INFO, "Submit Button Was Not Found");	
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;			
		} catch(Exception ex) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}	
		
		
	}
	
	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws Throwable {
		
		securityRealmPage = PageFactory.initElements(driver, SecurityRealmpage.class);
		Boolean userCreated = false;
		try {
			extentTestRef.log(LogStatus.INFO, "Checking if User Exists on UsersScreen");	
			userCreated = securityRealmPage.hasUserBeenCreated(driver, UserInfo.UserName);
		} catch (NoSuchElementException e){
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		} catch(Exception ex) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}
		
		if(!userCreated) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}
		
		assertEquals("The UserName should be visible on the UsersScreen", true, userCreated);
		extentTestRef.log(LogStatus.PASS, "User Was Created And Found On UsersScreen ");	
		extentReportRef.endTest(extentTestRef);
    	extentReportRef.flush();
		driver.close();
		iTestCounter++;
	}
	
	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, and \"([^\"]*)\" Fullname are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_and_Fullname_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4) throws Throwable {
	    
		UserInfo.setUserFullUserInfo(arg1, arg2, arg3, arg4, arg1 + "@gmail.com");
		
		createUserPage = PageFactory.initElements(driver, CreateUserPage.class);
		
		try {
			createUserPage.setUserInputByIndex(0, UserInfo.UserName);
			createUserPage.setUserInputByIndex(1, UserInfo.Password);
			createUserPage.setUserInputByIndex(2, UserInfo.ConfirmPassword);
			createUserPage.setUserInputByIndex(3, UserInfo.FullName);
			createUserPage.setUserInputByIndex(4, UserInfo.Email);
			extentTestRef.log(LogStatus.INFO, "Entered User Details:- " + UserInfo.getUserFullUserInfoAsString() );	
		}  catch (NoSuchElementException e) {
			extentTestRef.log(LogStatus.INFO, "Submit Was Not Found");	
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;	
						
		} catch(Exception ex) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}
				
	}
	
	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) throws Throwable {
		securityRealmPage = PageFactory.initElements(driver, SecurityRealmpage.class);
		Boolean userCreated = false;
		try {
			extentTestRef.log(LogStatus.INFO, "Checking if User Exists on UsersScreen");	
			userCreated = securityRealmPage.hasUserBeenCreated(driver, arg1);
		} catch (NoSuchElementException e){
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}  catch(Exception ex) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}
		
		if(!userCreated) {
			extentReportRef.endTest(extentTestRef);
	    	extentReportRef.flush();
			driver.close();
			iTestCounter++;
		}
		
		assertEquals("The UserName should be visible on the UsersScreen", true, userCreated);
		extentTestRef.log(LogStatus.PASS, "User Was Created And Found On UsersScreen ");	
		extentReportRef.endTest(extentTestRef);
    	extentReportRef.flush();
		driver.close();
		iTestCounter++;
		
	}
	
	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^I change the old FullName on the Configure Page to a new FullName \"([^\"]*)\"$")
	public void i_change_the_old_FullName_on_the_Configure_Page_to_a_new_FullName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the Configure Page should show the NewFullName \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_NewFullName(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
