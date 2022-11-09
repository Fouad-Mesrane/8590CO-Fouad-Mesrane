package pageObjectModel;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[href='https://ui.freecrm.com/']")
    WebElement loginBtn;
    @FindBy(css = "a[href='https://api.freecrm.com/register/']")
    WebElement signUpBtn;

    @FindBy(css = "a[href='https://freecrm.com/contact.html']")
    WebElement contactUsBtn;


    public LoginPage toLoginPage() {
        clickOnElement(loginBtn);

        return new LoginPage();
    }

}