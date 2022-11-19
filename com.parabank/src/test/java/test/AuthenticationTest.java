package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class AuthenticationTest extends BasePage {

    @Test(priority = 1)
    public void validateLogin() throws SQLException, IOException {
        HomePage homePage = new HomePage();
        // used credentials from database
        LandingPage landingPage = homePage.authentication();
        Assert.assertTrue(landingPage.validateLoginAndRegistration());
    }

    @Test(priority = 2)
    public void validateErrorLogin() {
        HomePage homePage = new HomePage();
        LandingPage landingPage = homePage.errorLogin();
        Assert.assertFalse(landingPage.validateLoginAndRegistration());
    }
}
