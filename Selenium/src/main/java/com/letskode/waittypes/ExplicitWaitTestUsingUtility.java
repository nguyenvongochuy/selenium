package com.letskode.waittypes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.WaitTypes;

//ImplicitWait: tell Selenium wait more a certain of time before throw exceptions
//and apply for all elements after page load and wait

//ExplicitWait: tell Selenium wait more a certain of time with particular event elementToBeClickable, visibilityOfElementLocated
//and apply for particular element 

public class ExplicitWaitTestUsingUtility {
	public static final String webUrl = "https://letskodeit.teachable.com/pages/practice";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	private WaitTypes waitTypes;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		waitTypes = new WaitTypes(driver);
		
	}
	
	@Test
	public void waitExplicitTest() throws InterruptedException {
		driver.get(webUrl);
		driver.findElement(By.linkText("Login")).click();
		
		WebElement email = waitTypes.waitForElement(By.id("user_email"), 3);
		email.sendKeys("test");
		
		waitTypes.clickWhenReady(By.name("commit"), 3);
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
