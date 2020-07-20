package com.selencodes.report.screenshotreport;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName += ".png";
        String directory = "/home/huy/Downloads/";
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(directory + fileName));

        return directory+fileName;
    }
}
