package com.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTestFirefox {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for Firefox
	private String driverPath = "resources/geckodriver"; // linux driver for Firefox
	private WebDriver driver;
	
	@BeforeTest(groups="firefox")
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(webUrl);
	}
	
	@Test(groups="firefox")
	public void verifyHomeTitle() {
		String expectedTitle="Practice | Let's Kode It";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest(groups="firefox")
	public void closeBrowser() {
		driver.close();
	}
	
	
}
