package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public final class HomePage {
    /**
     PageFactory is being used to initialize the WebElements
    */
    private WebDriver driver;
    /**
     * Constructor for the ProductDetailPage class.
     * Initializes the WebDriver and PageFactory for the class.
     * @param driver The WebDriver instance.
     */
    public HomePage(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[normalize-space()='15mm Combo Wrench']")
    private WebElement productName;

    public ProductDetailPage navigateProductDetailPage(){
        productName.click();
        return new ProductDetailPage(driver);
    }

}
