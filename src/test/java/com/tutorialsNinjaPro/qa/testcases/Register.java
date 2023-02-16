package com.tutorialsNinjaPro.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Register extends Base{
	
	WebDriver driver;
	
	public Register() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		driver = initialiseBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']/self::a[1]")).click();
	}
	@Test(priority=1)
	public void fillAllTheMandatoryFileldsProvidingValidDetailes() {
		driver.findElement(By.id("input-firstname")).sendKeys("charle");
		driver.findElement(By.id("input-lastname")).sendKeys("Luise");
		driver.findElement(By.id("input-email")).sendKeys("charleLuise@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("7894561");
		driver.findElement(By.id("input-password")).sendKeys("Welcome123");
		driver.findElement(By.id("input-confirm")).sendKeys("Welcome123");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click();
	}
	
	@Test(priority=2)
	public void fillAllTheMandatoryFiedsAndContinueWithoutClickingPrivacyButton() {
		driver.findElement(By.id("input-firstname")).sendKeys("charle");
		driver.findElement(By.id("input-lastname")).sendKeys("Luise");
		driver.findElement(By.id("input-email")).sendKeys("charleLuise@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("7894561");
		driver.findElement(By.id("input-password")).sendKeys("Welcome123");
		driver.findElement(By.id("input-confirm")).sendKeys("Welcome123");
		driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click();
		
		String warningMessageRegistered =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessageRegisterd= " Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue((warningMessageRegistered.contains(expectedWarningMessageRegisterd)),"Expected Warning Message is Not Displayed");
	}
	
	@Test(priority=3)
	public void clickContinueButtonWithoutFillingInputBoxes() {
		
		driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click();		
		String warningMessageRegistered =driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		String expectedWarningMessageRegisterd= " Warning: You must agree to the Privacy Policy!";
		Assert.assertTrue((warningMessageRegistered.contains(expectedWarningMessageRegisterd)),"Expected Warning Message is Not Displayed");
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
