package com.letskode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LetsKodeItTest {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(webUrl);
	}
	
	@Test
	public void findPriceForCourseName() {
		String courseName = "Python Programming Language";
		String xPath = ".//table[@id='product']//td[text()='" + courseName + "']";
		xPath += "//following-sibling::td"; //go to below td to get value
		System.out.println("xpath: " + xPath);
		WebElement course = driver.findElement(By.xpath(xPath));
		
		String actualCourseValue = course.getText();
		String expectedCourseValue="30";
		Assert.assertEquals(actualCourseValue, expectedCourseValue);
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() {
		driver.close();
	}
}
