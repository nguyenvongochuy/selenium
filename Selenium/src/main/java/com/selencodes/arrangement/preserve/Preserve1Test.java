package com.selencodes.arrangement.preserve;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Preserve1Test {
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


    @Test
    public void preserve1Test1() {
        System.out.println("preserve1Test1");

    }

    @Test
    public void preserve1Test2() {
        System.out.println("preserve1Test2");
    }



}
