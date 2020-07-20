package com.selencodes.firefoxprofile.firefoxprofile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxProfileTest {

    // view profile in Ubuntu:
    // located in home/<user>/.mozilla/firefox/
    // to create profile use:  ./firefox -p  (E.g. create name "seleniumprofile"

    public static void main(String[] argv) {
        String driverPath = "resources/geckodriver"; // linux driver for firefox
        String url = "http://www.google.com";
        WebDriver driver;

        //driver = new FirefoxDriver((Capabilities) firefoxProfile);  //not run
        System.setProperty("webdriver.gecko.driver", driverPath);
        ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile firefoxProfile = profilesIni.getProfile("seleniumprofile");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setProfile(firefoxProfile);
        driver =  new FirefoxDriver(opt);

        driver.manage().window().maximize();
        driver.get(url);


    }

}
