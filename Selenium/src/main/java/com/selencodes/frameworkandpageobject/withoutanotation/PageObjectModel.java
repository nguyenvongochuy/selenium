package com.selencodes.frameworkandpageobject.withoutanotation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageObjectModel {
	public static final String webUrl = "https://www.expedia.com";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	private JavascriptExecutor js;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		
		driver.get(webUrl);
	}
	
	@Test
	public void searchPageTest() throws InterruptedException {
		SearchPageFactory.originTextBox(driver).sendKeys("New York");
		SearchPageFactory.destinationTextBox(driver).sendKeys("Chicago");
		SearchPageFactory.departureDateTextBox(driver).sendKeys("07/14/2020");
		SearchPageFactory.returnDateTextBox(driver).sendKeys("07/29/2020");
		SearchPageFactory.clickOnSearchButton(driver);
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
