package com.letskodeit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownSelect {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
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
		
		WebElement element = driver.findElement(By.id("carselect"));
		Select select = new Select(element);
		
		Thread.sleep(2000);
		select.selectByValue("benz");
		
		Thread.sleep(2000);
		select.selectByIndex(2);
		
		Thread.sleep(2000);
		select.selectByVisibleText("BMW");
		
		//display all dropdown values
		List<WebElement> options = select.getOptions();
		for (WebElement option : options){
			System.out.println(option.getText());
		}
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() {
		driver.close();
	}
}
