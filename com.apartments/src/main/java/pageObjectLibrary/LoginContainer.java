package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateData;
import utils.TestDataReader;

public class LoginContainer extends BasePage {
    public LoginContainer(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "loginContainer")
    WebElement loginContainer;
    @FindBy(id = "iFrameResizer0")
    WebElement formiFrame;
    @FindBy(xpath = "//*[@id=\"iframe\"]")
    WebElement frame;
    @FindBy(css = "#username")
    WebElement username;
    @FindBy(css = "#password")
    WebElement passwordField;
    @FindBy(id = "loginButton")
    WebElement loginBtn;


    public LandingPage authentication(String email, String password){
        waitForEleToBeVisible(loginContainer);

        switchToFrameByElement(formiFrame);

        sendKeysToElement(username, email);
        sendKeysToElement(passwordField, password);
        clickOnElement(loginBtn);
        return new LandingPage();
    }

    public LandingPage errorLogin(String email, String password){
        waitForEleToBeVisible(loginContainer);

        switchToFrameByElement(formiFrame);

        sendKeysToElement(username, email);
        sendKeysToElement(passwordField, password);
        clickOnElement(loginBtn);
        return new LandingPage();
    }
}
