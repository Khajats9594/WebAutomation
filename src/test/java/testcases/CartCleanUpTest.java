package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartCleanUpTest {

    @Test
    public void cartCleanUpTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web-playground.ultralesson.com/");

        String productNameToSelect = "15mm Combo Wrench";
        String productNavigationURL = "/products/";
        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='15mm Combo Wrench']"));
        product.click();
        WebElement addToCart = driver.findElement(By.xpath("//button[@name='add']"));
        addToCart.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id=\"cart-notification-button\"]")));
        viewCart.click();
        WebElement removeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//cart-remove-button[@id='Remove-1']")));
        removeBtn.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[normalize-space()='Your cart is empty']"), "Your cart is empty"));
        WebElement emptyMessage = driver.findElement(By.xpath("//h1[normalize-space()='Your cart is empty']"));
        assert emptyMessage.getText().equals("Your cart is empty"):"Assertion failed: Cart is not empty after removal.";
        driver.quit();
    }
}
