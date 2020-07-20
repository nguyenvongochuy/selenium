package com.selencodes.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportTest {


    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
        Reporter.log("setUp", true);
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("cleanUp");
        Reporter.log("cleanUp", true);

    }

    @Test
    public void listener2TestTest1() {
        System.out.println("test1");
        Reporter.log("test1", true);
    }

    @Test
    public void listener2TestTest2() {
        System.out.println("test2");
        Reporter.log("test2", true);
        Assert.assertTrue(false);
    }

    @Test
    public void listener2TestTest3() {
        System.out.println("test3");
        Reporter.log("test3", true);
    }

}
