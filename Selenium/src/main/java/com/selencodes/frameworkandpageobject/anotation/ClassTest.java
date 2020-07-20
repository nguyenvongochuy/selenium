package com.selencodes.frameworkandpageobject.anotation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ClassTest {
	//public static final String webUrl = "https://www.expedia.com";
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	private JavascriptExecutor js;
	private AnotationPageObjectPracticePage search;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		
		search = new AnotationPageObjectPracticePage(driver);
		
		driver.get(webUrl);
	}
	
	@Test
	public void searchPageTest() throws InterruptedException {
		search.clickCarDropDown();
		search.chooseMultiSelect(new int[]{0,1});
		search.chooseMultiSelect(new int[]{1,2});
		//search.clickFlightTab();
		//search.roundTrip();
		//search.oneWay();
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
