package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver ;
	//Objects
	@FindBy(xpath="//label[text()='E-Mail Address']/following::input[1]")
	private WebElement emailAddressField;
	
	@FindBy(xpath="//label[text()='E-Mail Address']/following::input[2]")
	private WebElement passwordField;

	@FindBy(xpath="//label[text()='E-Mail Address']/following::input[3]")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	//Actions
	public void enterEmailAddress(String emailText) {
		emailAddressField.sendKeys(emailText);
	}
	public void enterPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	public void clickLoginButton() {
		loginButton.click();
	}
	
	
	
	
	
}
