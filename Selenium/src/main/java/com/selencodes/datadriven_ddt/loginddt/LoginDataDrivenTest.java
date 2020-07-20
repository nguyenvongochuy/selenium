package com.selencodes.datadriven_ddt.loginddt;

import com.selencodes.datadriven_ddt.loginddt.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginDataDrivenTest {
    public static final String webUrl = "https://sso.teachable.com/secure/42299/users/sign_in?clean_login=true&reset_purchase_session=1";
    //private String driverPath = "resources/chromedriver-v83.exe"; // windows driver for chrome
    private String driverPath = "resources/chromedriver"; // linux driver for chrome
    private WebDriver driver;
    private JavascriptExecutor js;
    private String stringExcelFilePath = "/home/huy/IdeaProjects/selenium/Selenium/src/main/java/com/letskode/datadriven_ddt/loginddt/data/excelTest.xlsx";
    private String sheetName = "Sheet1";

    private String[][] dataResult;

    @DataProvider(name = "inValidLoginData")
    public Object[][] dataProvider() {
        return readDataFromExcel(this.stringExcelFilePath, this.sheetName, "Invalid_Login");
    }

    @BeforeTest
    public void launchBrowser() {
        System.out.println("Launching web browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;

        driver.get(webUrl);
    }

    private String[][] readDataFromExcel(String StringExcelFilePath, String sheetName, String dataSection) {

        ExcelUtils.setExcelFile(StringExcelFilePath, sheetName);
        String[][] dataResult = ExcelUtils.getTestData(dataSection);

        for (String[] row : dataResult) {
            for (String value : row)
                System.out.print(value + " ");
            System.out.println();
        }

        return dataResult;
    }

    @Test(dataProvider = "inValidLoginData")
    public void invalidLoginDDT(String username, String password) throws InterruptedException {
        System.out.println("Username: " + username + ", password: " + password);

        driver.findElement(By.id("user_email")).sendKeys(username);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();

    }


    @AfterTest(enabled = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
