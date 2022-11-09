package pageObjectModel;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjectModel.DashboardPage;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@placeholder='E-mail address']")
    WebElement emailAddress;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
    WebElement forgotPassword;

    @FindBy(xpath = "//*[@id=\"ui\"]/div/div/form/div/div[3]/p")
    WebElement loginErrorMsg;


    public DashboardPage authentication(String email, String pass) {
        sendKeysToElement(emailAddress, email);
        sendKeysToElement(password,pass);
        clickOnElement(loginBtn);
        return new DashboardPage();
    }


    public boolean validateLoginPage() {
        boolean isVisible = isElementVisible(forgotPassword);
        return isVisible;
    }

    public boolean validateErrorLoginMsg(){
        boolean isVisible = isElementVisible(loginErrorMsg);
        return isVisible;
    }

}