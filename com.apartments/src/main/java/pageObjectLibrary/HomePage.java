package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    // locators
    @FindBy(css = "a[title='Sign In']")
    WebElement signInBtn;

    @FindBy(css = "a[title='Sign Up']")
    WebElement signUpHeader;

    @FindBy(id = "headerMenuLink")
    WebElement menuBtn;

    @FindBy(id = "headerAddProperty")
    WebElement addPropertyBtn;

    @FindBy(id = "quickSearchLookup")
    WebElement searchInput;
    @FindBy(xpath = "//a[@title='Search apartments for rent']")
    WebElement searchBtn;
    @FindBy(id = "quickSearchLookup_typeahead_0")
    WebElement firstIndexSearchResult;







    public SignupPage navigateToSignUp() throws InterruptedException {
        clickOnElement(signUpHeader);
        return new SignupPage();

    }
    public LoginContainer navigateToLogin(){
        clickOnElement(signInBtn);
        return new LoginContainer();
    }

    public SearchResultsPage doSearch() throws InterruptedException {
        clearSendKeysToElement(searchInput, TestDataReader.getTestData().getProperty("city"));
        Thread.sleep(500);
        jsClickOnElement(searchBtn);
        return  new SearchResultsPage();
    }

    public AddPropertyPage navigateToAddProperty(){
        clickOnElement(addPropertyBtn);
        return new AddPropertyPage();
    }



}
