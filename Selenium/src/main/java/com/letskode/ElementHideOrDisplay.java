package com.letskode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ElementHideOrDisplay {
	public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
	public static final String webUrl2 = "https://www.expedia.com";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled=true)
	public void testElementHideShowLetsKode() throws InterruptedException {
		driver.get(webUrl);
		
		WebElement element = driver.findElement(By.id("displayed-text"));

		
		Thread.sleep(3000);
		driver.findElement(By.id("hide-textbox")).click();
		System.out.println("Status of textbox: " + element.isDisplayed());
		
		Thread.sleep(3000);
		driver.findElement(By.id("show-textbox")).click();
		System.out.println("Status of textbox: " + element.isDisplayed());
		
		if (element.isDisplayed()) {
			element.sendKeys("Hello added");
		}
		
	}
	
	@Test
	public void testExpedia() throws InterruptedException {
		driver.get(webUrl2);
		
		WebElement traveller = driver.findElement(By.cssSelector("#traveler-selector-hp-hotel > div > ul > li > button"));
		traveller.click();
		Thread.sleep(3000);

		//child
		WebElement child = driver.findElement(By.cssSelector("#traveler-selector-hp-hotel > div > ul > li > div > div > div.traveler-selector-room-data > div.children-wrapper > div.cols-nested.children-data.gcw-toggles-fields > label:nth-child(1) > select"));
		
		WebElement childPlus = driver.findElement(By.cssSelector("#traveler-selector-hp-hotel > div > ul > li > div > div > div.traveler-selector-room-data > div.children-wrapper > div.uitk-grid.step-input-outside.gcw-component.gcw-component-step-input.gcw-step-input.gcw-component-initialized > div:nth-child(4) > button > span.uitk-icon > svg"));
		System.out.println("Children displayed?: " + child.isDisplayed());
		Thread.sleep(3000);
		
		//click + children
		//driver.findElement(By.xpath("//div[contains(@class,'children-wrapper')]//div[contains(@class,'uitk-grid step-input-outside gcw-component gcw-component-step-input gcw-step-input gcw-component-initialized')]//button[contains(@class,'uitk-step-input-button uitk-step-input-plus')]//span[contains(@class,'uitk-icon')]//*[local-name()='svg']//*[name()='path' and contains(@d,'M19 13h-6v')]")).click();
		childPlus.click();
		System.out.println("Children displayed?: " + child.isDisplayed());
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() {
		driver.close();
	}
}
