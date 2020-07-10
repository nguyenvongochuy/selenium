package com.letskode.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXSource;

public class CustomListener1Test implements IInvokedMethodListener {

    // run before any method in Test class: setup, test, cleanup..
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Before Invocation: " + testResult.getTestClass().getTestName() +
                " --> " + method.getTestMethod().getMethodName());
    }

    // run after any method in Test class: setup, test, cleanup..
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("After Invocation: " + testResult.getTestClass().getTestName() +
                " --> " + method.getTestMethod().getMethodName());
    }



}
