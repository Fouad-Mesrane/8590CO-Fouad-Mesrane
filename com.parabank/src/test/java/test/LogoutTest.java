package test;

import base.BasePage;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;

import java.io.IOException;
import java.sql.SQLException;

public class LogoutTest extends BasePage {

    @Test(dataProvider = "credentials", dataProviderClass = AuthenticationTest.class)
    public void validateLogout(String username, String password) throws SQLException, IOException, InterruptedException {
        HomePage homePage = new HomePage();
        // used credentials from database
        LandingPage landingPage = homePage.authentication(username,password);
        landingPage.logout();
        Assert.assertTrue(homePage.validateLogout());
    }
}
