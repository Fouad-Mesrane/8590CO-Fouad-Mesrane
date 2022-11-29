package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import pageObjectLibrary.LoginContainer;
import utils.GenerateData;
import utils.TestDataReader;

public class AuthenticationTest extends BasePage {

    @Test
    public void validateLogin(){
        HomePage homePage = new HomePage();
        LoginContainer login = homePage.navigateToLogin();
        LandingPage landingPage = login.authentication(TestDataReader.getTestData().getProperty("email"),TestDataReader.getTestData().getProperty("password"));
        Assert.assertTrue(landingPage.isVisibleBtn());
    }
    @Test
    public void errorLoginValidation(){
        HomePage homePage = new HomePage();
        LoginContainer login = homePage.navigateToLogin();
        LandingPage landingPage = login.errorLogin(GenerateData.email(),GenerateData.password());
        Assert.assertFalse(landingPage.isVisibleBtn());
    }
}