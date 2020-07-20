package com.selencodes.arrangement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SequenceTest {
    /*public static final String webUrl = "https://letskodeit.teachable.com/p/practice";
    private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
    //private String driverPath = "resources/chromedriver"; // linux driver for chrome
    private WebDriver driver;
    private JavascriptExecutor js;*/

    @BeforeTest
    public void launchBrowser() {
        System.out.println("Launching web browser");
       /* System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

        driver.get(webUrl);*/
    }

    @AfterTest(enabled=true)
    public void closeBrowser() throws InterruptedException {
      /*  Thread.sleep(2000);
        driver.close();*/
    }

    @Test(priority = 1)
    public void run2() throws InterruptedException {
        System.out.println("Run test 2");

    }

    @Test(priority = 0)
    public void run1() throws InterruptedException {
        System.out.println("Run test 1");

    }

}
