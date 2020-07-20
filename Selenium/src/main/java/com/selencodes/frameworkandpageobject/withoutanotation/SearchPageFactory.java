package com.selencodes.frameworkandpageobject.withoutanotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageFactory {
	public static WebElement element = null;
	
	/**
	 * Return the flight origin text box element
	 * @param driver
	 * @return
	 */
	public static WebElement originTextBox(WebDriver driver){
		return driver.findElement(By.id("flight-origin"));
	}
	
	/**
	 * Return the flight destination text box element
	 * @param driver
	 * @return
	 */
	public static WebElement destinationTextBox(WebDriver driver){
		return driver.findElement(By.id("flight-destination"));
	}
	
	/**
	 * Return the departure date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement departureDateTextBox(WebDriver driver){
		return driver.findElement(By.id("flight-departing"));
	}
	
	/**
	 * Return the return date text box element
	 * @param driver
	 * @return
	 */
	public static WebElement returnDateTextBox(WebDriver driver){
		return driver.findElement(By.id("flight-returning"));
	}
	
	/**
	 * Return the search button element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver){
		return driver.findElement(By.id("search-button"));
	}
	
	/**
	 * Click on search button
	 * @param driver
	 * @return
	 */
	public static void clickOnSearchButton(WebDriver driver){
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flight tab
	 * @param driver
	 * @return
	 */
	public static void navigateToFlightTab(WebDriver driver){
		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab"));
		element.click();
	}
	
	
}
