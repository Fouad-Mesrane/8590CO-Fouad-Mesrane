package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {
    public LandingPage(){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]/div[1]/div[1]/header/div/section/div/div/div[2]/div[2]/button")
    WebElement profileIconBtn;

    // method to validate signup and login
    public boolean validateSignupAndSignin(){
        return isElementVisible(profileIconBtn);
    }
}
