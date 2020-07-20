package com.selencodes.report.extendreport;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//include Maven
/*<dependency>
<groupId>com.relevantcodes</groupId>
<artifactId>extentreports</artifactId>
<version>2.40</version>
</dependency>*/


public class ExtendReportTest {

    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeClass
    public void setUp() {
        extentReports = new ExtentReports("/home/huy/Downloads/testExtendReport.html");
        extentTest = extentReports.startTest("verify test");

        extentTest.log(LogStatus.INFO, "in Setup");

        System.out.println("setUp");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("cleanUp");

        extentTest.log(LogStatus.INFO, "in Cleanup");
        extentReports.endTest(extentTest);
        extentReports.flush();
    }

    @Test
    public void listener2TestTest1() {
        System.out.println("test1");
        Reporter.log("test1", true);

        extentTest.log(LogStatus.PASS, "in Test1");
    }

    @Test
    public void listener2TestTest2() {
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
