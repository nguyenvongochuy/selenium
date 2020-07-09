package com.letskode.arrangement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EnableTimeoutTest {
    /*public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
    private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
    //private String driverPath = "resources/chromedriver"; // linux driver for chrome
    private WebDriver driver;
    private JavascriptExecutor js;*/

    @BeforeTest(alwaysRun = true)
    public void launchBrowser() {
        System.out.println("Launching web browser");
       /* System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

        driver.get(webUrl);*/
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
      /*  Thread.sleep(2000);
        driver.close();*/
        System.out.println("After class");
    }


    @Test(enabled = false)  //not allow to run
    public void test1() {
        System.out.println("test1");

    }

    @Test(timeOut = 100)  //fail if run longer than 100ms
    public void test2() throws InterruptedException {
        System.out.println("test2");
        Thread.sleep(200);
    }



}
