package com.letskode.listener.i_invoked_method_listener;

import org.testng.annotations.*;

@Listeners(CustomListener1Test.class)
public class ListenerTest {


    @BeforeClass
    public void setUp() {
        System.out.println("setUp");
    }

    @AfterClass
    public void cleanUp() {
        System.out.println("cleanUp");

    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }


}
