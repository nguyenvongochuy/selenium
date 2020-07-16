package com.seleniumgrid.gridparallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPageObject {
    WebDriver driver;

    @FindBy(id = "name")
    WebElement textBoxName;

    @FindBy(id = "alertbtn")
    WebElement alert;

    public TestPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterName(String name) {
        textBoxName.sendKeys(name);
    }

    public void displayAlert() {
        alert.click();
    }

}
