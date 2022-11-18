package pageObject;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class OrderReceiptPage extends BasePage {

    public OrderReceiptPage(){
        PageFactory.initElements(driver,this);
    }

    By orderConfirmationMsg = By.xpath("//*[@id=\"center_column\"]/div/p/strong");


    public boolean validateOrderConfirmation(){
        boolean match = getVisibleElement(orderConfirmationMsg).getText().equalsIgnoreCase("Your order on My Store is complete.");
        return match;
    }
}