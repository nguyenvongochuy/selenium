package com.letskode.waittypes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//ImplicitWait: tell Selenium wait more a certain of time before throw exceptions
// and apply for all elements after page load and wait

//ExplicitWait: tell Selenium wait more a certain of time with particular event elementToBeClickable, visibilityOfElementLocated
//and apply for particular element 

public class ImplicitWaitTest {
	public static final String webUrl = "https://letskodeit.teachable.com/pages/practice";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Add implicitWait for tell selenium wait more time after page load (apply to all elements)
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void waitImplecitTest() throws InterruptedException {
		driver.get(webUrl);
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("user_email")).sendKeys("test");
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
