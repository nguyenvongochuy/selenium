package com.selencodes.parameter_parallel.browserparallel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class ParallelBrowserTest {
    public static final String webUrl = "https://letskodeit.teachable.com/";
    private String driverChromePath = "resources/chromedriver-v83.exe"; // windows driver for chrome
    private String driverFirefoxPath = "resources/geckodriver.exe"; // windows driver for chrome
    //private String driverPath = "resources/chromedriver"; // linux driver for chrome
    private WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverChromePath);
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driverFirefoxPath);
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get(webUrl);
    }


    @Test
    public void login() {
        driver.findElement(By.xpath("//a[contains(@href, '/sign_in')]")).click();
        //driver.findElement(By.id("user_email")).sendKeys("aaa");
        //driver.findElement(By.id("user_password")).sendKeys("b");
        //driver.findElement(By.name("commit")).click();


    }

    @AfterClass
    public void cleanUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();

    }

}
