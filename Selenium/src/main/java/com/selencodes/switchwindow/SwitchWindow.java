package com.selencodes.switchwindow;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SwitchWindow {
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
	public void switchWindow() throws InterruptedException {
		driver.get(webUrl);
	
		//Save windows handle name
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window: " + parentWindow);
		
		//Click to open new windows button
		WebElement element = driver.findElement(By.id("openwindow"));
		element.click();
		
		//Enter search course name python in next window
		Set<String> windowHandles = driver.getWindowHandles();
		String nextWindowHandle = null;
		for (String windowHandle : windowHandles){
			if (!windowHandle.equals(parentWindow)) {
				nextWindowHandle = windowHandle;
				break;
			}
		}
		
		
		System.out.println("next window: " + nextWindowHandle);
		if (nextWindowHandle!=null) {
			driver.switchTo().window(nextWindowHandle);
			driver.findElement(By.id("search-courses")).sendKeys("Python");
			driver.findElement(By.id("search-course-button")).click();
			Thread.sleep(2000);
			driver.close();
		}
		
		driver.switchTo().window(parentWindow);
		js.executeScript("window.scrollBy(0, 100);");
		driver.findElement(By.id("name")).sendKeys("test");
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
