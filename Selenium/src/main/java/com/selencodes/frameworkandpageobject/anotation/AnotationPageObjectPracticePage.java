package com.selencodes.frameworkandpageobject.anotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AnotationPageObjectPracticePage {

	private WebDriver driver;
	

	@FindBy(id="carselect")
	private WebElement carDropdown;

	@FindBy(id = "multiple-select-example")
	private WebElement multiSelect;

	public AnotationPageObjectPracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public WebElement getMultiSelect() {
		return multiSelect;
	}

	public WebElement getCarDropdown() {
		return carDropdown;
	}


	public void clickCarDropDown(){
		carDropdown.click();
	}

	public void chooseMultiSelect(int[] indexes){
		if (indexes.length!=0) {
			Select select = new Select(multiSelect);
			select.deselectAll();
			for (int i=0; i<indexes.length; i++) {
				select.selectByIndex(indexes[i]);
			}

		}

	}

}
