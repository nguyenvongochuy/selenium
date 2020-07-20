package com.selencodes.listener.i_suite_listener;

import com.selencodes.listener.i_all_custom_listener.CustomListener4Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListener4Test.class)
public class Listener1Test {


    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("cleanUp");

    }

    @Test
    public void listener1test1() {
        System.out.println("Listener1 Test --> test1");
    }

    @Test
    public void listener1test2() {
        System.out.println("Listener1 Test --> test2");
        Assert.assertTrue(false);
    }


}
