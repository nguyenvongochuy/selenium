package com.selencodes.javascripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollElement {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
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
	}
	
	@Test
	public void scrollElement() throws InterruptedException {
		//driver.get(webUrl);
		js.executeScript("window.location = '" + webUrl + "'");
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		
		//js.executeScript("window.scrollBy(0,-1000)");
		//Thread.sleep(2000);
		
		WebElement element = driver.findElement(By.id("mousehover"));
		//js.executeScript("arguments[0].scrollIntoView(true);", element); //fill element object to argument[0]
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-100)");
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
