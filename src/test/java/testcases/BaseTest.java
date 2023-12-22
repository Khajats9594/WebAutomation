package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Objects;

public class BaseTest {

    protected BaseTest(){}

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        if(Objects.isNull(driver)) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    @AfterMethod
    public void tearDown(){
        if(Objects.nonNull(driver)) {
            driver.quit();
        }
    }
}
