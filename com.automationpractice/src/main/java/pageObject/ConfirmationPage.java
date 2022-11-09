package pageObject;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BasePage {

    public ConfirmationPage(){
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "h1")
    WebElement myAccountText;




    public boolean validateVisibleElement(){

        WebElement element = webDriverWait.until(ExpectedConditions.visibilityOf(myAccountText));
        boolean match = element.getText().equalsIgnoreCase("MY ACCOUNT");
        return match;


    }


}