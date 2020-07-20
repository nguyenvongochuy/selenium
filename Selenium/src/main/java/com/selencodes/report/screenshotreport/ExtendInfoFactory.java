package com.selencodes.report.screenshotreport;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtendInfoFactory {
    public static ExtentReports getInstance() {
        ExtentReports extentReports;
        String path = ScreenshotReportTest.fileName;
        extentReports = new ExtentReports(path, false);
        extentReports
                .addSystemInfo("Selenium version", "2.52")
                .addSystemInfo("Platform", "Ubuntu");

        return extentReports;
    }
}
