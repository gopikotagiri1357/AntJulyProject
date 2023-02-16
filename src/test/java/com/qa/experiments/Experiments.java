package com.qa.experiments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Experiments extends Base {

	public Experiments() {
		super();
	}

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		driver = initialiseBrowserAndOpenApplicationURL(prop.getProperty("browser"));
	}

	@Test
	public void pickEcpectedDateFromCalender() {

		String year = "2023";
		String month = "July";
		String date = "15";

		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();

		while(true) {

			String monthYear = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			String [] arr=monthYear.split(" ");
			String mon= arr[0];
			String year1 = arr[1];

			if(mon.equalsIgnoreCase(month) && year1.equalsIgnoreCase(year)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//td[@class='next']")).click();
			}
		}
		List<WebElement>dates = driver.findElements(By.xpath("//table[@class='rb-monthTable first last']//td"));
		for(WebElement actualDates : dates) {
			String allDates =actualDates.getText();

			if(allDates.equals(date)) {
				actualDates.click();
				break;
			}
		}
	}
}
