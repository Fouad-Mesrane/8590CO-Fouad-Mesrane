package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".item-title > span > a")
    List<WebElement> itemsInCart;

    public boolean validateItemsInCart(){
        return isElementVisible(itemsInCart.get(0));
    }
}
