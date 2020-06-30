package com.letskode.advances;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutoComplete {
	public static final String webUrl = "https://www.southwest.com";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void autoCompleteTest() throws InterruptedException {
		driver.get(webUrl);
		
		String searchString = "New York";
		String autoCompleted = "New York (LaGuardia), NY - LGA";

		WebElement element = driver.findElement(By.id("LandingAirBookingSearchForm_originationAirportCode"));
		element.click();
		element.sendKeys(autoCompleted);
		element.sendKeys(Keys.ENTER);
		
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='form-control--message'][@xpath='1']"));
		System.out.println(elements.size());
		//element.click();
		
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
}
