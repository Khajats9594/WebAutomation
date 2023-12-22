package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager() {} // Private constructor to prevent external instantiation
    // ThreadLocal to store separate WebDriver instances for each thread
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    /**
     * Retrieves the WebDriver instance for the current thread.
     * @return The WebDriver instance.
     */
    public static WebDriver getDriver() {
        return dr.get();
    }
    /**
     * Sets the WebDriver instance for the current thread.
     * @param driver The WebDriver instance to set.
     */
    static void setDriver(WebDriver driver) {
        dr.set(driver);
    }
    /**
     * Unloads the WebDriver instance for the current thread.
     */
    static void unload() {
        dr.remove();
    }
}
