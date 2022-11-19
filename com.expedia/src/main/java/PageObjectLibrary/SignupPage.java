package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateData;

public class SignupPage extends BasePage {

    public SignupPage(){
        PageFactory.initElements(driver,this);
    }
    // =========== Locators ===========
    @FindBy(xpath = "//input[@id='signupFormEmailInput']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='signupFormFirstNameInput']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='signupFormLastNameInput']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='signupFormPasswordInput']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@id='signupFormSubmitButton']")
    WebElement continueBtn;

    public LandingPage register(){
        sendKeysToElement(emailField, GenerateData.email());
        sendKeysToElement(firstNameField, GenerateData.firstName());
        sendKeysToElement(lastNameField, GenerateData.lastName());
        sendKeysToElement(passwordField, GenerateData.password());
        waitForEleToBeVisible(continueBtn);
        clickOnElement(continueBtn);
        return new LandingPage();
    }
}
