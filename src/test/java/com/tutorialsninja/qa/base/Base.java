package com.tutorialsninja.qa.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninjapro.qa.utilities.Utilities;

public class Base {

	public WebDriver driver;
	public Properties prop; 

	public Base() {
		prop = new Properties();
		try {
			FileInputStream fileinput = new FileInputStream("C:\\Users\\91818\\eclipse-workspace\\tutorialsNinjaPro\\src\\main\\java\\com\\tutorialsninjapro\\qa\\cofigure\\config.properties");
			prop.load(fileinput);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriver initialiseBrowserAndOpenApplicationURL(String browserName) {

		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get("https://www.redbus.in/");

		return driver;
	}
}
