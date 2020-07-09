package com.letskode.arrangement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupTest {
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

    @Test(groups = {"car", "suv"} )
    public void testBMWX6() throws InterruptedException {
        System.out.println("testBMWX6");

    }

    @Test(groups = {"car", "sedan"} )
    public void testAudiA6() throws InterruptedException {
        System.out.println("testAudiA6");

    }

    @Test(groups = {"bike"} )
    public void testNinja() throws InterruptedException {
        System.out.println("testNinja");

    }

    @Test(groups = {"bike"} )
    public void testHondaCBR() throws InterruptedException {
        System.out.println("testHondaCBR");

    }

}
