package pageObject;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.GenerateData;

public class HomePage extends BasePage {

    public HomePage() {



        PageFactory.initElements(driver, this);

    }

    // Navigating to Registration page region
    @FindBy(css = ".login")
    WebElement signInBtnHeader;


    @FindBy(xpath = "//input[@id='email_create']")
    WebElement createAccEmail;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccBtn;

    // Authentication region

    @FindBy(css = "#email")
    WebElement loginEmail;

    @FindBy(css = "#passwd")
    WebElement loginPassword;

    @FindBy(css = "#SubmitLogin")
    WebElement loginBtn;

    // login error message region

    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/p")
    WebElement errorMessage;

    // searchBar region
    @FindBy(id = "search_query_top")
    WebElement searchBarInput;

    @FindBy(css = ".button-search")
    WebElement searchBarBtn;

    // validating already existing email accounts error message

    @FindBy(css = "#create_account_error > ol > li")
    WebElement existingEmail;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement signOutBtn;


    public RegistrationPage toRegistrationPage() {
        String email = GenerateData.email();
        clickOnElement(signInBtnHeader);
        sendKeysToElement(createAccEmail, email);
        clickOnElement(createAccBtn);

        return new RegistrationPage();

    }

    public LandingPage authentication(String email, String password) {
        clickOnElement(signInBtnHeader);
        sendKeysToElement(loginEmail, email);
        sendKeysToElement(loginPassword, password);
        clickOnElement(loginBtn);

        return new LandingPage();
    }

    public String getLoginErrorMessage() {
        String errorMsg = webDriverWait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
        return errorMsg;
    }

    public String getexistingEmailErrorMessage(String email) {
        clickOnElement(signInBtnHeader);
        sendKeysToElement(createAccEmail, email);
        clickOnElement(createAccBtn);
        String errorMsg = webDriverWait.until(ExpectedConditions.visibilityOf(existingEmail)).getText();
        return errorMsg;
    }

    public SearchResultsPage search(String searchWord) {
        sendKeysToElement(searchBarInput, searchWord);
        clickOnElement(searchBarBtn);
        return new SearchResultsPage();
    }

    public void signOut() {
        clickOnElement(signOutBtn);
    }
}
