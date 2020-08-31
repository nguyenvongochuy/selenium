package com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static By getByFromWebElement(WebElement element) {
        By by = null;
        String[] pathVariables = (element.toString().split("->")[1].replaceFirst("(?s)(.*)\\]", "$1" + "")).split(":");

        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {

            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
            case "tag name":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
            case "css selector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!!!");
        }
        return by;
    }

    public static void explicitWaitByWebElementvisibilityOfElementLocated(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Utilities.getByFromWebElement(element)));
    }
    
    public static void explicitWaitByWebElementvisibilityOfElementLocated(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public static void explicitWaitByElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(Utilities.getByFromWebElement(element)));
    }
    
    public static void explicitWaitByElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    
    public static void explicitWaitForAlert(WebDriver driver) {
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
    }
    
    /**
     * Some error happen when click on button image, with this error:
     * Selenium Web Driver & Java. Element is not clickable at point (x, y). Other element would receive the click
     * --> Should use this function
     * @param driver
     * @param element
     */    
    public static void clickByJavascript(WebDriver driver, WebElement element) {
    	JavascriptExecutor executor = (JavascriptExecutor) driver;
    	executor.executeScript("arguments[0].click()", element);
    }
    
}

