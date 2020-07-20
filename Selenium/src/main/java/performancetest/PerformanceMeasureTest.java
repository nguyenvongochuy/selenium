package performancetest;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PerformanceMeasureTest {
    public static final String webUrl = "https://www.edureka.co";
    //private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
    private String driverPath = "resources/chromedriver"; // linux driver for chrome
    private WebDriver driver;

    // manually calculate
    private long startTime;
    private long endTime;
    private double durationInSecond;

    //or can use stopwatch
    StopWatch stopWatch =  new StopWatch();

    @BeforeTest
    public void launchBrowser() {
        System.out.println("Launching web browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();

    }

    @Test
    public void verifyHomeTitleTest() {
        startTime = System.nanoTime();
        //can also use stopwatch
        stopWatch.start();


        driver.get(webUrl);
        endTime = System.nanoTime();
        durationInSecond = (endTime-startTime)/1000000000.0; //divide billion to get second from nanosecond
        double seconds = stopWatch.getTime() / 1000.0; //convert to second

        System.out.println("Time executed: " + String.valueOf(durationInSecond) + " seconds");
        System.out.println("Time executed (by stopwatch):" + seconds + " seconds");
        stopWatch.reset();


    }

    @AfterTest(enabled = true)
    public void closeBrowser() {
        driver.close();
    }


}
