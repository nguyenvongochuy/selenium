package greenfield.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	private WebDriver driver;
	
	@BeforeTest
	public void lauchBrowser() {
		System.out.println("Launching web browser");
		System.setProperty(Common.CHROME_DRIVER, Common.DRIVER_PATH);
		driver = new ChromeDriver();
		driver.get(Common.WEB_URL);
	}
	
	@Test
	public void verifyLoginFail() {
		WebElement username =  driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password =  driver.findElement(By.id("password"));
		password.sendKeys("nop");
		driver.findElement(By.cssSelector("#command > input[type=submit]:nth-child(11)")).submit();
		
		String title = "Login";
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@Test
	public void verifyLoginPass() {
		WebElement username =  driver.findElement(By.id("username"));
		username.sendKeys("admin");
		WebElement password =  driver.findElement(By.id("password"));
		password.sendKeys("admin");
		driver.findElement(By.cssSelector("#command > input[type=submit]:nth-child(11)")).submit();
		
		String title = "Home";
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
