package com.selencodes.uploadfile.autoit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.IOException;

// Go to Windows download Autoit to record the step to upload

public class UploadFileUseAutoItSample {

    public static void main(String[] argv) throws AWTException, IOException {
        String driverPath = "resources/chromedriver"; // linux driver for firefox
        String url = "http://www.google.com";


        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(url);

        //try to browser to compose to create email.... (just dummy)
        //TODO

        //Select file and paste it to file dialog
        Runtime.getRuntime().exec("c:\\user\\user1\\fileupload.exe");

        //click button to upload



    }
}
