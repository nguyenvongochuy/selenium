package com.seleniumgrid.gridparallel;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridParallelTest {
    private String baseUrl = "https://letskodeit.teachable.com/p/practice";
    private String remoteNodeUrl = "http://192.168.0.92/wd/hub";
    private WebDriver driver;
    private TestPageObject test;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(remoteNodeUrl), desiredCapabilities);

        test = new TestPageObject(driver);
        

    }

    @Test
    public void Test() {
        test.enterName("Test from Grid parallel");
        test.displayAlert();
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
