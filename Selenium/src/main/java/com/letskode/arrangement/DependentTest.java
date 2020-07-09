package com.letskode.arrangement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DependentTest {
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

    //assume test1 depend on test2, test3 depend on test 1
    //--> test2 -> test1 -> test3 (test4 any random)
    @Test(dependsOnMethods = {"test2"})
    public void test1() throws InterruptedException {
        System.out.println("test1");

    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println("test2");
        int num = 2+1;
        Assert.assertEquals(2, num);
    }

    @Test(dependsOnMethods = {"test1"})
    public void test3() throws InterruptedException {
        System.out.println("test3");

    }

    @Test
    public void test4() throws InterruptedException {
        System.out.println("test4");

    }

}
