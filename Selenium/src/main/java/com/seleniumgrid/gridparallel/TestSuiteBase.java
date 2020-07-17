package com.seleniumgrid.gridparallel;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestSuiteBase {
    protected WebDriver driver;
    protected TestPageObject test;

    @Parameters({"platform", "browser", "version", "url", "nodeUrl"})
    @BeforeClass(alwaysRun = true)
    public void setup(String platform, String browser, String version, String url, String nodeUrl) throws MalformedURLException {
        driver = getDriverInstance(platform, browser, version, url, nodeUrl);
        test = PageFactory.initElements(driver, TestPageObject.class);
    }

    public static WebDriver getDriverInstance(String platform, String browser, String version, String url, String nodeUrl) throws MalformedURLException {
        //String nodeUrl = "http://192.168.0.185:5555/wd/hub";
        WebDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();

        //Platform
        if (platform.equalsIgnoreCase("windows")) {
            caps.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("linux")) {
            caps.setPlatform(Platform.LINUX);
        }
        if (platform.equalsIgnoreCase("mac")) {
            caps.setPlatform(Platform.MAC);
        }

        //Browser
        if (browser.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();

        }
        if (browser.equalsIgnoreCase("firefox")) {
            caps = DesiredCapabilities.firefox();
        }

        //Version
        caps.setVersion(version);
        driver = new RemoteWebDriver(new URL(nodeUrl), caps);

        //Maximize Windows
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(url);

        return driver;
    }

    @AfterClass
    public void afterclass() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

}
