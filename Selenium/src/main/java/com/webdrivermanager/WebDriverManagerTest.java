package com.webdrivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest {
	private WebDriver driver;
	
	@BeforeTest
	public void initialTest(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void runTest1() {
		driver.get("https://www.toolsqa.com/");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
}
