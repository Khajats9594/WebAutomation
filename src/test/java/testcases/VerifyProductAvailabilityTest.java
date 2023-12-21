package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductAvailabilityTest {

    @Test
    public void verifyingProductAvailabilityTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web-playground.ultralesson.com/");
        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='12 Ti Xelium Skis']"));
        product.click();
        //check if the product is available or sold out
        WebElement availabilityMessage = driver.findElement(By.xpath("//button[@name='add']"));
        String message = availabilityMessage.getText();
        if (message.contains("Sold Out")) {
            //log the appropriate message and exit the test
            System.out.println("product is sold out.Test will be terminated.");
            Assert.fail("product is Sold Out");
        } else {
            //product is available
            System.out.println("product is available for purchase");
        }
    }
}

