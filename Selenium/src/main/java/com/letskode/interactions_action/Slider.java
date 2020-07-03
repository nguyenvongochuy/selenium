package com.letskode.interactions_action;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Slider {
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
		
		driver.get(webUrl);
	}
	
	@Test
	public void sendKey() throws InterruptedException {
		
		WebElement element = driver.findElement(By.xpath("//a[contains(@href,'sign_in')]"));
		element.click();
		
		//find username
		driver.findElement(By.id("user_email")).sendKeys("test@email.com");
		driver.findElement(By.id("user_email")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("user_password")).sendKeys("123");
		driver.findElement(By.name("commit")).sendKeys(Keys.ENTER);
	}
	
	
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
