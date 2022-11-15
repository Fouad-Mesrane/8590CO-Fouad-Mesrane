package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    public LandingPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"username\"]/button")
    WebElement usernameBtn;



    public boolean isVisibleBtn(){
        boolean isVisible = isElementVisible(usernameBtn);
        return isVisible;
    }
}