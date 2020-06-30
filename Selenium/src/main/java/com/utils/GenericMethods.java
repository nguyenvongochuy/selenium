package com.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	private WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {
		WebElement element = null;
		switch (type.toLowerCase()) {
		case "id":
			element = driver.findElement(By.id(locator));
			break;
		case "css":
			element = driver.findElement(By.cssSelector(locator));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(locator));
			break;
		case "name":
			element = driver.findElement(By.name(locator));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(locator));
			break;
		case "partialLinkText":
			element = driver.findElement(By.partialLinkText(locator));
			break;
		}

		if (element == null) {
			System.out.println("Type: " + type + " , location: " + locator + " does not supported");
		} else {
			System.out.println("Type: " + type + " , location: " + locator + " found");
		}
		return element;

	}

	public List<WebElement> getElements(String locator, String type) {
		List<WebElement> elements = null;
		switch (type.toLowerCase()) {
		case "id":
			elements = driver.findElements(By.id(locator));
			break;
		case "css":
			elements = driver.findElements(By.cssSelector(locator));
			break;
		case "xpath":
			elements = driver.findElements(By.xpath(locator));
			break;
		case "name":
			elements = driver.findElements(By.name(locator));
			break;
		case "linkText":
			elements = driver.findElements(By.linkText(locator));
			break;
		case "partialLinkText":
			elements = driver.findElements(By.partialLinkText(locator));
			break;
		}
		if (elements == null ) {
			System.out.println("Type: " + type + " , location: " + locator + " does not supported");
		} else if (elements.size() == 0 ) {
			System.out.println("Type: " + type + " , location: " + locator + " does not found");
		} else {
			System.out.println("Type: " + type + " , location: " + locator + " found");
		}
		return elements;
	}

	public boolean isElementPresent(String locator, String type) {
		List<WebElement> elements = getElements(locator, type);
		if (elements==null)
			return false;
		return elements.size() > 0;
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
