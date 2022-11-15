package pageObject;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage() {
        PageFactory.initElements(driver, this);
    }

    //find products list
    //
    @FindBy(css = ".product_list > li >.product-container >.right-block > h5 > .product-name")
    List<WebElement> productsList;

    @FindBy(css=".exclusive:first-child")
    WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement checkoutBtn;



    public WebElement getProduct(String productName) {
        WebElement product = productsList.stream().filter(prod -> prod.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);

        return product;
    }



    public CartPage addToCart(String productName) {
        WebElement prod = getProduct(productName);
        hoverOverElement(prod);
        clickOnElement(prod);
        clickOnElement(addToCartBtn);
        clickOnElement(checkoutBtn);
        return new CartPage();

    }




}
