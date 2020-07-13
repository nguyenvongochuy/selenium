package com.letskode.eventlistener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class Main {
    public static void main(String[] argv) {
        String url = "http://www.google.com";
        WebDriver driver = new ChromeDriver();

        EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
        HandleEvents handleEvents = new HandleEvents();
        eDriver.register(handleEvents);

        eDriver.get(url);
        //click signin
        eDriver.findElement(By.id("gb_70")).click();

    }

}
