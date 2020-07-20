package com.selencodes.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "inputs")
    public Object[][] getData() {
        return new Object[][]{
                {"bmw", "m3"},
                {"audi", "a6"},
                {"benz", "c300"}
        };
    }



    @Test(dataProvider = "inputs")
    public void test1(String param1, String param2) {
        System.out.println("Param 1: " +param1);
        System.out.println("Param 2: " +param2);
    }


}
