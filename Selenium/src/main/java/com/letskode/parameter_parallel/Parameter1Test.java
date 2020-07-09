package com.letskode.parameter_parallel;

import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class Parameter1Test {


    @BeforeClass
    public void setup() {
        System.out.println("Parameter1Test");
    }


    @Test
    public void test1() throws InterruptedException {
        System.out.println("Parameter1Test --> test1");
        Thread.sleep(5000);
        System.out.println("Parameter1Test --> test1 continue");
    }


}
