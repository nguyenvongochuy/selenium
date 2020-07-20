package com.selencodes.alertmessage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CatchAlertMessage {
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
	public void catchInformationMessage() throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys("Bob");
		driver.findElement(By.id("alertbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();  //select OK button
		
		Thread.sleep(2000);
	
	}
	
	@Test
	public void catchConfirmationMessage() throws InterruptedException {
		driver.findElement(By.id("name")).sendKeys("Bob");
		driver.findElement(By.id("confirmbtn")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		//alert.accept();  //select OK button
		alert.dismiss(); //select Cancel button
	
		Thread.sleep(2000);
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
