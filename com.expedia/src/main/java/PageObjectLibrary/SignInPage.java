package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateData;

import java.sql.SQLException;

public class SignInPage extends BasePage {
    public SignInPage(){
        PageFactory.initElements(driver,this);
        //databaseInit();
    }
    //=========== Locators ==============
    @FindBy(xpath = "//input[@id='loginFormEmailInput']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='loginFormPasswordInput']")
    WebElement passwordField;
    @FindBy(xpath = "//button[@id='loginFormSubmitButton']")
    WebElement signinBtn;

    @FindBy(xpath = "//h3[@class='uitk-error-summary-heading']")
    WebElement errorLoginMsg;

    public LandingPage doSignIn() throws SQLException {
        String getEmailQuery = "Select email from selenium_bootcamp_data.com_expedia_credentials";
        String getPasswordQuery = "Select AccPassword from selenium_bootcamp_data.com_expedia_credentials";
        sendKeysToElement(emailField,db.executeQueryReadOne(getEmailQuery).toString());
        sendKeysToElement(passwordField,db.executeQueryReadOne(getPasswordQuery).toString());
        waitForEleToBeVisible(signinBtn);
        clickOnElement(signinBtn);
        return new LandingPage();
    }

    public void doErrorSignIn()  {

        sendKeysToElement(emailField, GenerateData.email());
        sendKeysToElement(passwordField,GenerateData.password());
        waitForEleToBeVisible(signinBtn);
        clickOnElement(signinBtn);

    }

    public boolean validateErrorLogin(){
        return isElementVisible(errorLoginMsg);
    }

}
