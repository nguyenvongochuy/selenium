package com.selencodes.uploadfile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class UploadFileSample {

    public static void main(String[] argv) throws AWTException {
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
        StringSelection stringSelection = new StringSelection("C:\\temp1\\file1.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        //Ctrl-V and enter
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);




    }
}
