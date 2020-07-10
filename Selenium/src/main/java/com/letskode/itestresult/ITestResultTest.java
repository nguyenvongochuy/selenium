package com.letskode.itestresult;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ITestResultTest {

    @Test
    public void test1() {
        System.out.println("test1");
        Assert.assertTrue(false);
    }


    @Test
    public void test2() {
        System.out.println("test2");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void cleanUp(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            System.out.println("TC fail name: " + iTestResult.getMethod().getMethodName());
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            System.out.println("TC pass name: " + iTestResult.getMethod().getMethodName());
        }
    }
}
