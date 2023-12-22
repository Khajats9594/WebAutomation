package testcases;

import driver.Driver;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    protected BaseTest(){}

    @BeforeMethod
    public void setUp(){
        Driver.initDriver(BrowserType.CHROME);
    }

    @AfterMethod
    public void tearDown(){
        Driver.quiteDriver();
    }
}
