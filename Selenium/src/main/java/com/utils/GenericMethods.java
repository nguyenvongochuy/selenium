package com.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericMethods {
	private WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(String locator, String type) {
		switch (type.toLowerCase()) {
		case "id":
			return driver.findElement(By.id(locator));
		case "css":
			return driver.findElement(By.cssSelector(locator));
		case "xpath":
			return driver.findElement(By.xpath(locator));
		case "linkText":
			return driver.findElement(By.linkText(locator));
		case "partialLinkText":
			return driver.findElement(By.partialLinkText(locator));
		default:
			System.out.println("Type does not existed");
			return null;
		}
	}

	public List<WebElement> getElements(String locator, String type) {
		switch (type.toLowerCase()) {
		case "id":
			return driver.findElements(By.id(locator));
		case "css":
			return driver.findElements(By.cssSelector(locator));
		case "xpath":
			return driver.findElements(By.xpath(locator));
		case "linkText":
			return driver.findElements(By.linkText(locator));
		case "partialLinkText":
			return driver.findElements(By.partialLinkText(locator));
		default:
			System.out.println("Type does not existed");
			return null;
		}
	}
	
	public boolean isElementPresent(String locator, String type){
		List<WebElement> elements = getElements(locator, type);
		return elements.size()>0;
	}

}
