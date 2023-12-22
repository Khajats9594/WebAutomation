package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ValidatingProductCartContentsTest {

    @Test
    public void validatingProductCartContentsTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://web-playground.ultralesson.com/");

        String productNameToSelect = "15mm Combo Wrench";
        String productNavigationURL = "/products/";
        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='15mm Combo Wrench']"));
        product.click();

        //get the initial cart item count
        WebElement cartItemCount = driver.findElement(By.xpath("//*[contains(@class, 'icon-cart')]"));
        String initialItemCount = cartItemCount.getAttribute("class").contains("empty") ? "0" : driver.findElement(By.className("cart-count-bubble")).getText();

        WebElement addToCart = driver.findElement(By.xpath("//button[@name='add']"));
        addToCart.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='cart-notification-button']")))
                .click();
        //Fetching the product name
        String productName = driver.findElement(By.xpath("//tr[@id='CartItem-1']//td//dd"))
                .getText().trim();
        //asserting the product name with fetched name
        Assert.assertEquals(productName,productNameToSelect,"product Name did not match");
        //Fetching the product quantity
        String productQuantity = driver.findElement(By.xpath("//input[@aria-label='Quantity for 15mm Combo Wrench']"))
                .getAttribute("value");
        //asserting the productQuantity with fetched value
        Assert.assertEquals(productQuantity,"1","Product quantity did not matched");
       //Fetching the productPrice
        String productPrice = driver.findElement(By.xpath(" //td[@class='cart-item__totals right small-hide']//span"))
                .getText().trim();
        double productPrice1 = Double.parseDouble(productPrice.substring(productPrice.indexOf(".") + 1));
        //Fetching the totalPrice
        String totalPrice = driver.findElement(By.xpath("//div[@class=\"totals\"]//p")).getText().trim();
        double totalPrice1 = Double.parseDouble(totalPrice.substring(totalPrice.indexOf(".") + 1));
        //Fetching the discount price
        String discountPrice = driver.findElement(By.xpath("//li[@class='discounts__discount discounts__discount--end']")).getText().trim();
        double discount = Double.parseDouble(discountPrice.substring(discountPrice.indexOf(".") + 1, discountPrice.indexOf(")")));
        //asserting the productPrice with totalPrice+discountPrice
        Assert.assertEquals(productPrice1,totalPrice1+discount,"price dit not matched with total price");
        driver.quit();
    }
}
