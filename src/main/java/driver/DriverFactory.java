package driver;

import enums.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverFactory {

    private DriverFactory(){}// Private constructor to prevent external instantiation
    /**
     * Sets the WebDriver instance based on the specified BrowserType.
     * @param browserType The type of browser to set.
     */
    static void setDriver(BrowserType browserType){
        switch (browserType){
            case CHROME: {
                DriverManager.setDriver(new ChromeDriver());
                break;
            }
            case FIREFOX: {
                DriverManager.setDriver(new FirefoxDriver());
                break;
            }
            case EDGE: {
                DriverManager.setDriver(new InternetExplorerDriver());
                break;
            }
            case SAFARI:{
                DriverManager.setDriver(new SafariDriver());
                break;
            }
        }
    }
}
