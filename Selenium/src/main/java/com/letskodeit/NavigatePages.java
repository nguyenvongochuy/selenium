package com.letskodeit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NavigatePages {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	public static final String webUrl2 = "https://letskodeit.teachable.com/";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void navigatePages() throws InterruptedException {
		driver.get(webUrl);
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		Thread.sleep(2000);
		
		driver.get(webUrl2);
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		Thread.sleep(2000);
		driver.navigate().back();
		
		Thread.sleep(2000);
		driver.navigate().forward();
		
		Thread.sleep(2000);
		driver.navigate().refresh();
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() {
		driver.close();
	}
}
