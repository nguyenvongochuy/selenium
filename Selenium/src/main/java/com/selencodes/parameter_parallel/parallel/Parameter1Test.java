package com.selencodes.parameter_parallel.parallel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
