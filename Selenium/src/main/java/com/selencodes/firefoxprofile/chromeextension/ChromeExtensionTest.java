package com.selencodes.firefoxprofile.chromeextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class ChromeExtensionTest {
    //PURPOSE: to copy existing Chrome extension to Chrome test browser


    // Chrome extension save here in ubuntu
    // /home/<user>>/.config/google-chrome/Default/Extensions

    public static void main(String[] argv) {
        String driverPath = "resources/chromedriver"; // linux driver for firefox
        String url = "http://www.google.com";

        String chromeExtensionPath = "/home/huy/.config/google-chrome/Default/Extensions/aapocclcgogkmnckokdopfmhonfmgoek/0.10_0";

        WebDriver driver;

        //driver = new FirefoxDriver((Capabilities) firefoxProfile);  //not run
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addExtensions(new File(chromeExtensionPath + ".crx"));

        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get(url);


    }

}
