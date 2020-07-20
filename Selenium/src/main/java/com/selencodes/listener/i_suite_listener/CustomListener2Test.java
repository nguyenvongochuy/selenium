package com.selencodes.listener.i_suite_listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class CustomListener2Test implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {
        //When test class starts
        System.out.println("onTestStart --> test name: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        //run if test method run successfully
        System.out.println("onTestSuccess --> test name: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        //run if test method run fail
        System.out.println("onTestFailure --> test name: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        //run if test method skip
        System.out.println("onTestSkipped --> test name: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //ignore meaning
    }

    @Override
    public void onStart(ITestContext context) {
        // Before <test> tag of xml
        System.out.println("onStart --> test tag name: " + context.getName());
        ITestNGMethod methods[] = context.getAllTestMethods();
        System.out.println("These methods will be executed in this test tag");
        for (ITestNGMethod method : methods) {
            System.out.println(method.getMethodName());
        }
    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
