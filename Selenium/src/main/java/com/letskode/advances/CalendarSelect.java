package com.letskode.advances;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utils.GenericMethods;

public class CalendarSelect {
	public static final String webUrl = "https://www.expedia.com/";
	//private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
	private String driverPath = "resources/chromedriver"; // linux driver for chrome
	private WebDriver driver;
	private GenericMethods genericMethods;
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		genericMethods = new GenericMethods(driver);		
	}
	
	@Test
	public void selectCalendar() throws InterruptedException {
		WebElement e;
		driver.get(webUrl);
		if (driver.getCurrentUrl().equals("https://www.expedia.com/?pwaLob=wizard-hotel-pwa-v2")) {
			//*[@id="gc-custom-header-nav-bar-acct-menu"]/button
			e= genericMethods.getElement("//*[@id='gc-custom-header-nav-bar-acct-menu']/button", "xpath");
			if (e!=null) {
				e.click();
			}
		}
		
		//WebElement element = genericMethods.getElement("hotel-checkin-hp-hotel", "id");
		genericMethods.clickWhenReady(By.id("hotel-checkin-hp-hotel"), 3);
		//WebElement element = driver.findElement(By.id("hotel-checkin-hp-hotel"));
		//element.click();
		
		genericMethods.getElement("//div[@class='datepicker-cal-month'][1]//button[text()=' 30']", "xpath").click();
		
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
}
