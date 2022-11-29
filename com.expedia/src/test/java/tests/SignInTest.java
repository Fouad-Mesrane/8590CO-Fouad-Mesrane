package tests;

import PageObjectLibrary.HomePage;
import PageObjectLibrary.LandingPage;
import PageObjectLibrary.SignInPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GenerateData;

import java.sql.SQLException;

public class SignInTest extends BasePage {

    @Test(priority = 1)
    public void validateSignIn() throws SQLException {
        HomePage homePage = new HomePage();
        SignInPage signIn = homePage.toSignInPage();
        LandingPage landingPage = signIn.doSignIn();
        Assert.assertTrue(landingPage.validateSignupAndSignin());
    }

    @Test (priority = 2)
    public void validateErrorLogin(){
        HomePage homePage = new HomePage();
        SignInPage signIn = homePage.toSignInPage();
        signIn.doErrorSignIn(GenerateData.email(),GenerateData.password());
        Assert.assertTrue(signIn.validateErrorLogin());
    }
}
