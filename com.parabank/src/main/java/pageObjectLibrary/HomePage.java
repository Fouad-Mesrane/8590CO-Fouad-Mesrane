package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Database;
import utils.GenerateData;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
        // databaseInit();
    }

    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p[2]/a")
    WebElement registerLink;

    @FindBy(css = "input[name='username']")
    WebElement usernameField;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;
    @FindBy(css = "input[value='Log In']")
    WebElement loginBtn;



    public RegistrationPage navigateToRegistrationPage() {
        clickOnElement(registerLink);
        return new RegistrationPage();
    }

    public LandingPage authentication() throws SQLException, IOException {
        String query_username = "SELECT Username FROM selenium_bootcamp_data.com_parabank_credentials";
        String query_password = "SELECT AccPassword FROM selenium_bootcamp_data.com_parabank_credentials";

        sendKeysToElement(usernameField, db.executeQueryReadOne(query_username).toString());
        sendKeysToElement(passwordField, db.executeQueryReadOne(query_password).toString());
        clickOnElement(loginBtn);
        // i used autoit to handle authentication alert
        String executablePath = System.getProperty("user.dir") + "\\src\\main\\resources\\data\\auth.exe";
        Runtime.getRuntime().exec(executablePath);

        return new LandingPage();

    }

    public LandingPage errorLogin() {
        sendKeysToElement(usernameField, GenerateData.firstName());
        sendKeysToElement(passwordField, GenerateData.firstName());
        clickOnElement(loginBtn);
        return new LandingPage();
    }

    public boolean validateLogout(){
        return isElementVisible(registerLink);
    }



}
