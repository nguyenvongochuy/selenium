package com.letskode.listener.i_suite_listener;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Listeners(CustomListener2Test.class)
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
    public void listener2test1() {
        System.out.println("Listener2 Test --> test1");
    }

    @Test
    public void listener2test2() {
        System.out.println("Listener2 Test --> test2");
        Assert.assertTrue(false);
    }


}
