package com.letskode.advances;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureScreenshot {
	public static final String webUrl = "https://www.expedia.com/";
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
	
	@Test
	public void accessFlight() throws InterruptedException {
		driver.get(webUrl);
		
		String autoCompleted = "New York (LaGuardia), NY - LGA";

		//click to Flight button
		driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']//span[contains(@class,'icons-container')]")).click();;
		
		WebElement element = driver.findElement(By.id("flight-origin-hp-flight"));
		element.click();
		element.sendKeys(autoCompleted);
		element.sendKeys(Keys.ENTER);
		
		element = driver.findElement(By.id("flight-destination-hp-flight"));
		element.click();
		element.sendKeys(autoCompleted);
		element.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//form[@id='gcw-flights-form-hp-flight']//button[contains(@class,'btn-primary btn-action gcw-submit')]")).click();
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException, IOException {
		Thread.sleep(2000);
		
		String fileName = UUID.randomUUID().toString();
		String directory = "//screenshots//"; //create /screenshots and sudo chmod 777 /screenshots
		System.out.println("Image will be captured in folder: " + directory);
		
		File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		
		//capture screenshot
		
		
		driver.close();
	}
}
