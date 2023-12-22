package driver;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverFactory {

    private DriverFactory(){}// Private constructor to prevent external instantiation
    /**
     * Sets the WebDriver instance based on the specified BrowserType.
     *
     * @param browserType The type of browser to set.
     * @return
     */
    static WebDriver createDriver(BrowserType browserType){
        switch (browserType){
            case CHROME: {
                return new ChromeDriver();
            }
            case FIREFOX: {
               return new FirefoxDriver();
            }
            case EDGE: {
               return new InternetExplorerDriver();
            }
            case SAFARI:{
                return new SafariDriver();
            }
            default:{
                throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
    }
}
