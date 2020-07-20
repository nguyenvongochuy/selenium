package com.selencodes.frameworkandpageobject.withoutanotation;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindAllLinks {
	public static final String webUrl = "https://www.expedia.com";
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
	public void testLinksTest() throws InterruptedException {
		List<WebElement> lists = clickAbleLinks(driver);
		for (WebElement element : lists) {
			String href = element.getAttribute("href");
			
			try {
				//System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
				System.out.println("URL " + href);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}
	
	@AfterTest(enabled=true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
	
	public static List<WebElement> clickAbleLinks(WebDriver driver) {
		List<WebElement> canClickLinks = new ArrayList<>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.add(driver.findElement(By.tagName("img")));
		
		for (WebElement e : elements) {
			if (e.getAttribute("href")!=null) {
				canClickLinks.add(e);
			}
		}
		
		return canClickLinks;
		
	}
	
	public static String linkStatus(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
}
