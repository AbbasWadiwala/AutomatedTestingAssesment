package com.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody")
	private  WebElement userInfoFormBodyWebElement;
	
	@FindBy(xpath="//*[@id=\"username\"]")
	private  WebElement userNameTextFieldWebElement;
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private  WebElement passwordTextFieldWebElement;
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private  WebElement passwordConfirmTextFieldWebElement;
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private  WebElement fullNameTextFieldWebElement;
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[5]/td[2]/input")
	private  WebElement emailTextFieldWebElement;	
	
	@FindBy(xpath="//*[@id=\"yui-gen1-button\"]")
	private  WebElement createUserButtonWebElement;
	
	
//	public void setUserInputByIndex(int desiredIndexFieldInt, String desiredTextString) {
//		
//		List<WebElement> allElementsOfTagName_input = userInfoFormBodyWebElement.findElements(By.tagName("input"));
//		int elementsSize = allElementsOfTagName_input.size();
//		switch (desiredIndexFieldInt) {
//		case 0:
//			for(int i = 0; i < elementsSize; i++) {
//				try	{
//					/*allElementsOfTagName_input.get(i).findElement(By.name("username")).clear();
//					allElementsOfTagName_input.get(i).findElement(By.name("username")).sendKeys(desiredTextString);*/
//					userNameTextFieldWebElement.clear();	
//					userNameTextFieldWebElement.sendKeys(desiredTextString);					
//					break;
//				} catch (NoSuchElementException e) {}				
//			}
//			break;
//		case 1:	
//			for(int i = 0; i < elementsSize; i++) {
//				try	{
//					/*allElementsOfTagName_input.get(i).findElement(By.name("password1")).clear();
//					allElementsOfTagName_input.get(i).findElement(By.name("password1")).sendKeys(desiredTextString);*/
//					
//					passwordTextFieldWebElement.clear();	
//					passwordTextFieldWebElement.sendKeys(desiredTextString);	
//					break;
//				} catch (NoSuchElementException e) {}		
//			}
//			break;
//		case 2:
//			for(int i = 0; i < elementsSize; i++) {
//				try	{
//					/*allElementsOfTagName_input.get(i).findElement(By.name("password2")).clear();
//					allElementsOfTagName_input.get(i).findElement(By.name("password2")).sendKeys(desiredTextString);*/
//					
//					passwordConfirmTextFieldWebElement.clear();	
//					passwordConfirmTextFieldWebElement.sendKeys(desiredTextString);	
//					
//					break;
//				} catch (NoSuchElementException e) {}	
//			}
//			break;
//		case 3:
//			for(int i = 0; i < elementsSize; i++) {
//				try	{
//					/*allElementsOfTagName_input.get(i).findElement(By.name("fullname")).clear();
//					allElementsOfTagName_input.get(i).findElement(By.name("fullname")).sendKeys(desiredTextString);*/
//					
//					fullNameTextFieldWebElement.clear();	
//					fullNameTextFieldWebElement.sendKeys(desiredTextString);	
//					
//					break;
//				} catch (NoSuchElementException e) {}	
//			}			
//			break;
//		case 4:
//			for(int i = 0; i < elementsSize; i++) {
//				try	{
//					/*allElementsOfTagName_input.get(i).findElement(By.name("email")).clear();
//					allElementsOfTagName_input.get(i).findElement(By.name("email")).sendKeys(desiredTextString);*/
//					
//					emailTextFieldWebElement.clear();	
//					emailTextFieldWebElement.sendKeys(desiredTextString);	
//					
//					break;
//				} catch (NoSuchElementException e) {}	
//			}	
//			break;
//		
//		}
//				
//		
//		
//	}	
	
	public void setUserInputByIndex(int desiredIndexFieldInt, String desiredTextString) {		
	
		switch (desiredIndexFieldInt) {
		case 0:			
				try	{
						userNameTextFieldWebElement.clear();	
						userNameTextFieldWebElement.sendKeys(desiredTextString);					
						break;
				} catch (NoSuchElementException e) {}				
			
			break;
		case 1:				
				try	{					
						passwordTextFieldWebElement.clear();	
						passwordTextFieldWebElement.sendKeys(desiredTextString);	
						break;
				} catch (NoSuchElementException e) {}		
			
			break;
		case 2:			
				try	{					
						passwordConfirmTextFieldWebElement.clear();	
						passwordConfirmTextFieldWebElement.sendKeys(desiredTextString);	
					
						break;
				} catch (NoSuchElementException e) {}	
			
			break;
		case 3:			
				try	{
					fullNameTextFieldWebElement.clear();	
					fullNameTextFieldWebElement.sendKeys(desiredTextString);						
					break;
				} catch (NoSuchElementException e) {}	
				
			break;
		case 4:	
				try	{					
						emailTextFieldWebElement.clear();	
						emailTextFieldWebElement.sendKeys(desiredTextString);	
						
						break;
				} catch (NoSuchElementException e) {}	
				
			break;		
		}		
		
	}
	
	/*public List<WebElement> getFormWebElements() {
		List<WebElement> allElementsOfTagName_input	= userInfoFormBodyWebElement.findElements(By.tagName("zzzzaaaa"));
		
		allElementsOfTagName_input.add(userNameTextFieldWebElement);
		allElementsOfTagName_input.add(passwordTextFieldWebElement);
		allElementsOfTagName_input.add(passwordConfirmTextFieldWebElement);
		allElementsOfTagName_input.add(fullNameTextFieldWebElement);
		allElementsOfTagName_input.add(emailTextFieldWebElement);
		
		return allElementsOfTagName_input;		
	}*/
	
	
	public void submitUserDetails() {
		createUserButtonWebElement.click();
	}
			
}

