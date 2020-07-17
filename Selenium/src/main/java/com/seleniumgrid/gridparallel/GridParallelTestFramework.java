package com.seleniumgrid.gridparallel;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GridParallelTestFramework extends TestSuiteBase {

    @BeforeClass
    public void beforeClass() {

    }

    @AfterClass
    public void afterClass() {

    }

    @Test
    public void test() {
        test.enterName("test from framework");
        test.displayAlert();
    }

}
