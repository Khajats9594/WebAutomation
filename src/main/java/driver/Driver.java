package driver;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver(){} // Private constructor to prevent external instantiation

    /**
     * Initializes the WebDriver instance based on the specified BrowserType.
     * If no instance exists, creates a new one and configures it.
     * Uses synchronized to ensure thread safety in a multi-threaded environment.
     * @param browserType The type of browser to initialize.
     */
    public static synchronized void initDriver(BrowserType browserType){
        if(Objects.isNull(DriverManager.getDriver())){
            WebDriver driver = DriverFactory.createDriver(browserType);
            DriverManager.setDriver(driver);
        }
        DriverManager.getDriver().get("https://web-playground.ultralesson.com/");
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Quits the WebDriver instance if it exists and unloads it from the DriverManager.
     * Uses synchronized to ensure thread safety in a multi-threaded environment.
     */
    public static synchronized void quiteDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
