package com.letskode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.GenericMethods;

public class CheckElementPresent {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	private GenericMethods genericMethods;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		genericMethods = new GenericMethods(driver);		
	}
	
	@Test
	public void navigatePages() throws InterruptedException {
		driver.get(webUrl);
		
		List<WebElement> elements = genericMethods.getElements("//input[@type='text']", "xpath");
		for (WebElement element : elements) {
			System.out.println("Element contents: " + element.getText());
		}
		
		boolean foundElement = genericMethods.isElementPresent("//input[@type='text']", "xpath");
		System.out.println("element found: " + foundElement);
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() {
		driver.close();
	}
}
