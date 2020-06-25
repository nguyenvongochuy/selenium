package greenfield.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LocalizationTest {
	private WebDriver driver;
	
	@BeforeTest
	public void lauchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty(Common.CHROME_DRIVER, Common.DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(Common.WEB_URL);
	}
	
	@Test
	public void verifyHomeTitle() {
		String expectedTitle="Login";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void verifyMenuLabels() {
		String welcomeGuest = "Hello,";
		Assert.assertTrue(driver.getPageSource().contains(welcomeGuest));
		//click on language icon to change language
		driver.findElement(By.cssSelector("body > nav > div.text-white > a:nth-child(1) > img")).click();
		
		welcomeGuest = "Xin chào,";
		Assert.assertTrue(driver.getPageSource().contains(welcomeGuest));
		welcomeGuest = "Đăng nhập";
		Assert.assertTrue(driver.getPageSource().contains(welcomeGuest));
		
		//click on language to change back to English
		driver.findElement(By.cssSelector("body > nav > div.text-white > a:nth-child(1) > img")).click();
		
		welcomeGuest = "Hello,";
		Assert.assertTrue(driver.getPageSource().contains(welcomeGuest));
	}
	
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
