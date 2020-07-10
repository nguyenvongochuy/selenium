package com.letskode.dataprovider.seperateclass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {

    @DataProvider(name = "inputs")
    public Object[][] getData() {
        return new Object[][]{
                {"bmw", "m3"},
                {"audi", "a6"},
                {"benz", "c300"}
        };
    }


}
