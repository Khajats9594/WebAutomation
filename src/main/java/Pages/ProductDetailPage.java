package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ProductDetailPage {

    /**
        PageFactory is being used to initialize the WebElements
        */
    private WebDriver driver;
    /**
     * Constructor for the ProductDetailPage class.
     * Initializes the WebDriver and PageFactory for the class.
     * @param driver The WebDriver instance.
     */
    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@name='add']")
    private WebElement addToCart;

    @FindBy(xpath = "//tbody/tr")
    private WebElement countProductInCart;

    @FindBy(xpath = "//h2[normalize-space()='Item added to your cart']")
    private WebElement addToCartSuccessMessage;

    public ProductDetailPage addToCart(){
        addToCart.click();
        return this;
    }
    public String getAddToCartSuccessMessage(){
      return  new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(addToCartSuccessMessage))
                .getText().trim();
    }
}
