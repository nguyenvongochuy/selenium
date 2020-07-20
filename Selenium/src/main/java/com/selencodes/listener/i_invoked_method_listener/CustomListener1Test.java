package com.selencodes.listener.i_invoked_method_listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class CustomListener1Test implements IInvokedMethodListener {

    // run before any method in Test class: setup, test, cleanup..
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("Before Invocation: " + testResult.getTestClass().getName() +
                " --> " + method.getTestMethod().getMethodName());
    }

    // run after any method in Test class: setup, test, cleanup..
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("After Invocation: " + testResult.getTestClass().getName() +
                " --> " + method.getTestMethod().getMethodName());
    }



}
