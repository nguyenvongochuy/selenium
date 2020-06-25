package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
	public static final String webUrl = "https://www.edureka.com";
	private String driverPath = "chromedriver.exe";
	private WebDriver driver;
	
	@BeforeTest
	public void lauchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(webUrl);
	}
	
	@Test
	public void verifyHomeTitle() {
		String expectedTitle="Instructor";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	
}
