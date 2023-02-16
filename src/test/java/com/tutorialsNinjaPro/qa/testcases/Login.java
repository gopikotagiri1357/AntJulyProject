package com.tutorialsNinjaPro.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;

public class Login extends Base{

	WebDriver driver;
	LoginPage loginpage;
	public Login() {
		super();
	}
	@BeforeMethod
	public void setup() {
		driver=initialiseBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		homepage.selectLoginOption();
	}

	@Test(priority=1)
	public void verifyLoginWithValidCredentials(String email, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterPasswordField(password);
		loginpage.clickLoginButton();
}

	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials(String email, String password) {
		loginpage = new LoginPage(driver);
		loginpage.enterEmailAddress(email);
		loginpage.enterPasswordField(password);
		loginpage.clickLoginButton();
	}

	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword(String email, String password) {
		loginpage.enterEmailAddress(email);
		loginpage.enterPasswordField(password);
		loginpage.clickLoginButton();
	}

	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		driver.findElement(By.xpath("//label[text()='E-Mail Address']/following::input[1]")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.xpath("//label[text()='E-Mail Address']/following::input[2]")).sendKeys("Welcomeyou@123");
		driver.findElement(By.xpath("//label[text()='E-Mail Address']/following::input[3]")).click();
	}

	@Test(priority=5)
	public void verifyLoginWithoutProvidingCredentials() {
		driver.findElement(By.xpath("//label[text()='E-Mail Address']/following::input[1]")).sendKeys("");
		driver.findElement(By.xpath("//label[text()='E-Mail Address']/following::input[2]")).sendKeys("");
		driver.findElement(By.xpath("//label[text()='E-Mail Address']/following::input[3]")).click();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
