package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	private WebDriver driver;

	public WaitTypes(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement waitForElement(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Wait for max: " + timeout + "seconds for element to be available");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		} catch (Exception e) {
			System.out.println("Element did not appear on the web page");
		}
		
		return element;
	}
	
	public void clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		try {
			System.out.println("Wait for max: " + timeout + "seconds for element to be clickable");
			
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
		} catch (Exception e) {
			System.out.println("Element did not click on the web page");
		}
		
	}
	
}
