package com.letskode.interactions_action;

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

public class MouseHover {
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
	public void mouseHoverTop() throws InterruptedException {
		js.executeScript("window.scrollBy(0, 900);");
		Thread.sleep(3000);
		
		//find button need to move mouse hover
		WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverButton).perform(); //move mouse hover
		
		WebElement elementTop =driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Top']"));
		//element.click(); //can use this way also
		action.moveToElement(elementTop).click().perform(); //click to move to top page
		Thread.sleep(3000);
		
		
	}
	
	@Test
	public void mouseHoverRefresh() throws InterruptedException {
		js.executeScript("window.scrollBy(0, 900);");
		Thread.sleep(3000);
		
		//find button need to move mouse hover
		WebElement mouseHoverButton = driver.findElement(By.id("mousehover"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mouseHoverButton).perform(); //move mouse hover
		
		WebElement elementTop =driver.findElement(By.xpath("//div[@class='mouse-hover-content']//a[text()='Reload']"));
		//element.click(); //can use this way also
		action.moveToElement(elementTop).click().perform(); //click to move to top page
		Thread.sleep(3000);
		
		
	}
	
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}
}
