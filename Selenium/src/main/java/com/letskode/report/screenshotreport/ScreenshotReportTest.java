package com.letskode.report.screenshotreport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

//include Maven
/*<dependency>
<groupId>com.relevantcodes</groupId>
<artifactId>extentreports</artifactId>
<version>2.40</version>
</dependency>*/


public class ScreenshotReportTest {

    ExtentReports extentReports;
    ExtentTest extentTest;
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();

        driver.get("http://www.google.com");

        extentReports = new ExtentReports("/home/huy/Downloads/testExtendReport.html");
        extentTest = extentReports.startTest("verify test");

        extentTest.log(LogStatus.INFO, "in Setup");

        System.out.println("setUp");
    }

    @AfterMethod
    public void cleanUp(ITestResult testResult) throws IOException {
        //capture screenshot if fail
        if (testResult.getStatus() == ITestResult.FAILURE){
            String path = Screenshot.takeScreenshot(driver, testResult.getName());
            String imagePath = extentTest.addScreenCapture(path);
            extentTest.log(LogStatus.FAIL, "Verified fail", imagePath);
        }


        System.out.println("cleanUp");

        extentTest.log(LogStatus.INFO, "in Cleanup");
        extentReports.endTest(extentTest);
        extentReports.flush();

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

    @Test
    public void listener2TestTest1() {
        System.out.println("test1");
        Reporter.log("test1", true);

        extentTest.log(LogStatus.PASS, "in Test1");
    }

    @Test
    public void listener2TestTest2() throws IOException {
        System.out.println("test2");
        Reporter.log("test2", true);

        extentTest.log(LogStatus.FAIL, "in test fail");

        Assert.assertTrue(false);


    }

    @Test
    public void listener2TestTest3() {
        System.out.println("test3");
        Reporter.log("test3", true);

        extentTest.log(LogStatus.INFO, "in Test3");
    }

}
