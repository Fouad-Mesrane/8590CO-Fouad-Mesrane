package pageObject;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(){

        PageFactory.initElements(driver,this);
    }


    @FindBy(css = "#cart_summary> tbody> tr >.cart_description >p>a")
    List<WebElement> productsList;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement summaryCheckoutBtn;
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement addressCheckoutBtn;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    WebElement checkTermsBtn;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button")
    WebElement shippingCheckoutBtn;
    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
    WebElement payBtn;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement confirmButton;




    public OrderReceiptPage checkout(){
        clickOnElement(summaryCheckoutBtn);
        clickOnElement(addressCheckoutBtn);
        checkTermsBtn.click();
        clickOnElement(shippingCheckoutBtn);
        clickOnElement(payBtn);
        clickOnElement(confirmButton);

        return new OrderReceiptPage();
    }


    public boolean verifyProductDisplay(String productName) {
        boolean match = productsList.stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(productName));

        return match;
    }
}
