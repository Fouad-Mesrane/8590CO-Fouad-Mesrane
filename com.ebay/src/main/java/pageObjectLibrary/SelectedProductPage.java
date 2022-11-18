package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedProductPage extends BasePage {
    public SelectedProductPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@id='x-msku__select-box-1000']")
    WebElement selectColor;
    @FindBy(xpath = "//select[@id='x-msku__select-box-1001']")
    WebElement selectStorage;
    @FindBy(xpath = "//select[@id='x-msku__select-box-1002']")
    WebElement selectCarrier;
    @FindBy(xpath = "//*[@id=\"mainContent\"]/form/div[2]/div/div[2]/ul/li[2]/div/a")
    WebElement addToCartBtn;
    @FindBy(xpath = "//button[normalize-space()='No thanks']")
    WebElement declineProtectionBtn;
    @FindBy(css = ".app-atc-layer__actionRow > a:nth-child(2)")
    WebElement goToCart;


    public boolean validateProductSelection(){
        return isElementVisible(addToCartBtn);
    }

    public ShoppingCartPage addProductToCart(){
        if (isElementVisible(selectColor)){
            selectFromDropdownByIndex(selectColor,1);

        }
        if (isElementVisible(selectStorage)){
            selectFromDropdownByIndex(selectStorage,1);

        }
        if (isElementVisible(selectCarrier)){
            selectFromDropdownByIndex(selectCarrier,0);

        }

        clickOnElement(addToCartBtn);
        if (isElementVisible(declineProtectionBtn)){
            clickOnElement(declineProtectionBtn);
            return new ShoppingCartPage();
        }
        else if (isElementVisible(goToCart)){
            clickOnElement(goToCart);
            return new ShoppingCartPage();
        }

        return new ShoppingCartPage();
    }

}
