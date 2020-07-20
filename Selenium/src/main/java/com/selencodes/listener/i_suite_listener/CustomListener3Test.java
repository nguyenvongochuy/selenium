package com.selencodes.listener.i_suite_listener;

import org.testng.*;

public class CustomListener3Test implements ISuiteListener {


    /**
     * This method is invoked before the SuiteRunner starts.
     *
     * @param suite
     */
    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart: before suite starts");

    }

    /**
     * This method is invoked after the SuiteRunner has run all
     * the test suites.
     *
     * @param suite
     */
    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish: after suite completed");
    }
}
