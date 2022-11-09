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
    WebElement password;

    @FindBy(css = "#days")
    WebElement day;

    @FindBy(css = "#months")
    WebElement month;

    @FindBy(css = "#years")
    WebElement year;

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
    private String passwd = GenerateData.password();
    private String streetAddress = GenerateData.streetAddress();
    private String cityText = GenerateData.city();
    private String stateText = GenerateData.state();
    private String zipcodeText = GenerateData.zipCode();
    private String mobileNum = GenerateData.mobilePhone();



    public void fillRegistrationForm(){
        clickOnElement(radioBtnMr);
        sendKeysToElement(firstNameElement,firstNameText);
        sendKeysToElement(LastNameElement,lastNameText);
        sendKeysToElement(password, passwd);
        dob();
        fillAddressPart();

    }

    public void dob(){
        selectFromDropdownByValue(day,"17");
        selectFromDropdownByValue(month,"1");
        selectFromDropdownByValue(year,"1995");
    }

    public void fillAddressPart(){
        sendKeysToElement(firstName,firstNameText);
        sendKeysToElement(lastName,lastNameText);
        sendKeysToElement(address,streetAddress);
        sendKeysToElement(city,cityText);
        selectFromDropdownByVisibleText(state,stateText);
        sendKeysToElement(zipCode, zipcodeText);
        sendKeysToElement(mobile,mobileNum);
        sendKeysToElement(addressAlias, GenerateData.streetAddress());
    }

    public LandingPage doRegistration(){
        fillRegistrationForm();
        clickOnElement(submitAccount);

        return new LandingPage();

    }
}
