package com.selencodes.listener.i_test_listener;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener2Test.class)
public class Listener2Test {


    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("cleanUp");

    }

    @Test
    public void listener2TestTest1() {
        System.out.println("test1");
    }

    @Test
    public void listener2TestTest2() {
        System.out.println("test2");
        Assert.assertTrue(false);
    }


}
