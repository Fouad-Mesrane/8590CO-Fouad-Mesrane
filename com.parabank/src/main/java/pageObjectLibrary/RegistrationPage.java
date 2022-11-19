package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateData;
import utils.TestDataReader;

public class RegistrationPage extends BasePage {
    public RegistrationPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "customer.firstName")
    WebElement firstNameField;
    @FindBy(id = "customer.lastName")
    WebElement lastNameField;
    @FindBy(id = "customer.address.street")
    WebElement addressField;
    @FindBy(id = "customer.address.city")
    WebElement cityField;
    @FindBy(id = "customer.address.state")
    WebElement stateField;
    @FindBy(id = "customer.address.zipCode")
    WebElement zipCodeField;
    @FindBy(id = "customer.phoneNumber")
    WebElement phoneNumberField;
    @FindBy(id = "customer.ssn")
    WebElement ssnField;
    @FindBy(id = "customer.username")
    WebElement usernameField;
    @FindBy(id = "customer.password")
    WebElement passwordField;
    @FindBy(id = "repeatedPassword")
    WebElement confirmPasswordField;
    @FindBy(xpath = "//input[@value='Register']")
    WebElement submitBtn;
    String username = GenerateData.firstName()+ "-" + GenerateData.lastName();
    String password = GenerateData.password();

    public LandingPage fillRegistrationForm(){
        sendKeysToElement(firstNameField,GenerateData.firstName());
        sendKeysToElement(lastNameField,GenerateData.lastName());
        sendKeysToElement(addressField,GenerateData.streetAddress());
        sendKeysToElement(cityField,GenerateData.city());
        sendKeysToElement(stateField,GenerateData.state());
        sendKeysToElement(zipCodeField,GenerateData.zipCode());
        sendKeysToElement(phoneNumberField,GenerateData.mobilePhone());
        sendKeysToElement(ssnField, TestDataReader.readTestData().getProperty("ssn"));
        sendKeysToElement(usernameField, username);
        sendKeysToElement(passwordField,password);
        sendKeysToElement(confirmPasswordField,password);
        clickOnElement(submitBtn);
        return new LandingPage();
    }





}
