package com.seleniumgrid.gridparallel;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridParallelTest {
    private String baseUrl = "https://letskodeit.teachable.com/p/practice";
    private String remoteNodeWindowsUrl = "http://192.168.0.92:5555/wd/hub";
    private String remoteNodeLinuxUrl = "http://192.168.0.185:5555/wd/hub";
    private WebDriver driver;
    private WebDriver driver1;
    private TestPageObject test;
    private TestPageObject test1;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // For Windows node test
        DesiredCapabilities desiredCapabilitiesWindows = DesiredCapabilities.chrome();

        //desiredCapabilitiesWindows.setBrowserName("chrome");
        //desiredCapabilitiesWindows.setPlatform(Platform.WINDOWS);
        //desiredCapabilitiesWindows.setVersion("83.0");
        driver = new RemoteWebDriver(new URL(remoteNodeWindowsUrl), desiredCapabilitiesWindows);

        // For linux node test
        DesiredCapabilities desiredCapabilitiesLinux = DesiredCapabilities.firefox();

        //desiredCapabilitiesLinux.setBrowserName("chrome");
        //desiredCapabilitiesLinux.setPlatform(Platform.LINUX);
        //desiredCapabilitiesLinux.setVersion("83.0");
        driver1 = new RemoteWebDriver(new URL(remoteNodeLinuxUrl), desiredCapabilitiesLinux);

        test = new TestPageObject(driver);
        test1 = new TestPageObject(driver1);


    }

    @Test
    public void Test() throws InterruptedException {
        driver.get(baseUrl);
        driver1.get(baseUrl);
        test.enterName("Test from Grid parallel");
        test.displayAlert();
        test1.enterName("Test from Grid parallel");
        test1.displayAlert();

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        driver1.quit();
    }

}
