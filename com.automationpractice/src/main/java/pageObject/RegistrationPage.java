package pageObject;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.GenerateData;

public class RegistrationPage extends BasePage {

    public RegistrationPage() {

        PageFactory.initElements(driver, this);

    }
    @FindBy(css = "#id_gender1")
    WebElement radioBtnMr;

    @FindBy(css = "#customer_firstname")
    WebElement firstNameElement;

    @FindBy(css = "#firstname:last-child")
    WebElement firstName;

    @FindBy(css = "#lastname:last-child")
    WebElement lastName;

    @FindBy(css = "#customer_lastname")
    WebElement LastNameElement;

    @FindBy(css = "#passwd")
    WebElement passwordField;

    @FindBy(css = "#days")
    WebElement dayText;

    @FindBy(css = "#months")
    WebElement monthText;

    @FindBy(css = "#years")
    WebElement yearText;

    @FindBy(css = "#address1")
    WebElement address;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#id_state")
    WebElement state;

    @FindBy(css = "#postcode")
    WebElement zipCode;

    @FindBy(css = "#phone_mobile")
    WebElement mobile;

    @FindBy(css = "#alias")
    WebElement addressAlias;

    @FindBy(css = "#submitAccount")
    WebElement submitAccount;

    private String firstNameText = GenerateData.firstName();
    private String lastNameText = GenerateData.lastName();





    public void fillRegistrationFormFirstPart(String firstName, String lastName, String password){
        clickOnElement(radioBtnMr);
        sendKeysToElement(firstNameElement,firstName);
        sendKeysToElement(LastNameElement,lastName);
        sendKeysToElement(passwordField, password);



    }

    public void dob(String day, String month, String year){
        selectFromDropdownByValue(dayText,day);
        selectFromDropdownByValue(monthText,month);
        selectFromDropdownByValue(yearText,year);
    }

    public void fillAddressPart(){
        sendKeysToElement(firstName,firstNameText);
        sendKeysToElement(lastName,lastNameText);
        sendKeysToElement(address,GenerateData.streetAddress());
        sendKeysToElement(city,GenerateData.city());
        selectFromDropdownByVisibleText(state,GenerateData.state());
        sendKeysToElement(zipCode, GenerateData.zipCode());
        sendKeysToElement(mobile,GenerateData.mobilePhone());
        sendKeysToElement(addressAlias, GenerateData.streetAddress());
    }

    public LandingPage doRegistration(){

        clickOnElement(submitAccount);

        return new LandingPage();

    }
}
