package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigatingProductDetailPageTest {

    @Test
    public void navigatingProductDetailPageTest(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://web-playground.ultralesson.com/");
        String productNameToSelect = "15mm Combo Wrench";
        String productNavigationURL = "/products/";
        WebElement product = driver.findElement(By.xpath("//a[normalize-space()='15mm Combo Wrench']"));
        product.click();
        String expectedUrl = "/products/15mm-combo-wrench";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl),"navigate to the details page");

        WebElement productTitleElement = driver.findElement(By.xpath("//h1[@class=\"product__title\"]"));
        String actualProductTitle = productTitleElement.getText();
        String expectedProductTitle = "15mm Combo Wrench";
        Assert.assertEquals(actualProductTitle,expectedProductTitle,"incorrect product details are loaded");
        driver.quit();

    }
}
