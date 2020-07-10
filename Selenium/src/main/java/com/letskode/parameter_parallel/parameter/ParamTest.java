package com.letskode.parameter_parallel.parameter;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class ParamTest {


    @BeforeClass
    @Parameters({"browser", "platform"})
    public void setup(String browser, String platform) {
        System.out.println("Param 1: " + browser);
        System.out.println("Param 2: " + platform);
    }


    @Test
    @Parameters({"response"})
    public void test1(String response) {
        List<String> res = Arrays.asList(response.split(","));
        res.forEach(System.out::println);

    }


}
