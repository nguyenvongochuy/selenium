package com.letskode.dataprovider.seperateclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1Test {

    @Test(dataProvider = "inputs", dataProviderClass = Data.class)
    public void test1(String param1, String param2) {
        System.out.println("Param 1: " +param1);
        System.out.println("Param 2: " +param2);
    }


}
