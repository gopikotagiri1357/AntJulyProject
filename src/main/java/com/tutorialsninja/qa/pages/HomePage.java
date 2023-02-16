package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//a[@title='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[text()='Login']")
	WebElement loginOption;
	
	public HomePage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	//Actions
	public void clickOnMyAccount() {
		// TODO Auto-generated method stub
		myAccount.click();
	}

	public void selectLoginOption() {
		loginOption.click();		
	}

	

}
