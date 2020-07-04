package com.letskode.framework.anotation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPageAnotationFactory {

	private WebDriver driver;
	
//	@FindBy(xpath="//div[@class='StorefrontWizardRegionBEX all-b-margin-six']//li[2]//a[1]")
//	//@FindBy(css="#app > div:nth-child(1) > div > div > div > div.StorefrontWizardRegionBEX.all-b-margin-six > div > figure > div.wizardCard.all-t-padding-twelve.all-x-padding-six.SimpleContainer > div > div > div > ul > li.uitk-tab.uitk-tab-icon-text.active > a > svg")
//	private WebElement flightElement;
//	
//	@FindBy(xpath="//div[contains(@class,'uitk-tabs-content')]//li[1]//a[1]")
//	private WebElement roundTrip;
//	
//	@FindBy(xpath="//div[contains(@class,'uitk-tabs-inner-container')]//li[contains(@class,'active')]//a[contains(@class,'uitk-tab-anchor')]")
//	private WebElement oneWay;
	
	@FindBy(id="carselect")
	private WebElement carDropdown;
	
	public SearchPageAnotationFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
//	
//	public void clickFlightTab(){
//		flightElement.click();
//	}
//	
//	public void roundTrip(){
//		roundTrip.click();
//	}
//	
//	public void oneWay(){
//		oneWay.click();
//	}
	
	public void clickCarDropDown(){
		carDropdown.click();
	}
	
}
