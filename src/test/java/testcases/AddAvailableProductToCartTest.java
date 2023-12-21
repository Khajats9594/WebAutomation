package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddAvailableProductToCartTest {

    @Test
    public void addToCartTest() {
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://web-playground.ultralesson.com/");

        String productNameToSelect = "15mm Combo Wrench";
        String productNavigationURL = "/products/";
        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='15mm Combo Wrench']"));
        product.click();

        //get the initial cart item count
        WebElement cartItemCount = driver.findElement(By.xpath("//*[contains(@class, 'icon-cart')]"));
        String initialItemCount = cartItemCount.getAttribute("class").contains("empty") ? "0" : driver.findElement(By.className("cart-count-bubble")).getText();
        // System.out.println(items);

        WebElement addToCart = driver.findElement(By.xpath("//button[@name='add']"));
        addToCart.click();

        //wait for the message to be appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='Item added to your cart']")));
        assert message.getText().contains("Item added to your cart");

        //verify that the cart item count is incremented
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.className("cart-count-bubble"), initialItemCount)));
        // WebElement updatedCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='cart-icon-bubble']//*[name()='svg']")));
        String finalItemCount = driver.findElement(By.className("cart-count-bubble")).getText();

        assert !initialItemCount.equals(finalItemCount) : "Assertion failed: Cart item count not incremented.";

        System.out.println("Test passed: Product added to the cart and cart item count incremented successfully.");
        driver.quit();

    }
}
