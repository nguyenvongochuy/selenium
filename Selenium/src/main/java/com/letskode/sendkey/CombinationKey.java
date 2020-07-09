package com.letskode.sendkey;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CombinationKey {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	//private String driverPath = "resources/chromedriver"; // linux driver for chrome
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
	public void selectAll() throws InterruptedException {
		Actions action = new Actions(driver);
		// select all by Ctrl-A
		driver.findElement(By.id("openwindow")).sendKeys(Keys.CONTROL + "a");
		
		
		String selectAll = Keys.chord(Keys.CONTROL + "a");
		driver.findElement(By.id("openwindow")).sendKeys(selectAll);
		
		action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		
	}
	
	
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
