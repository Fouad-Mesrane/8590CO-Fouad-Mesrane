package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import pageObjectLibrary.SignupPage;
import utils.GenerateData;

public class SignupTest extends BasePage {

    @Test
    public void validateSignup() throws InterruptedException {
        HomePage homePage = new HomePage();
        SignupPage signup = homePage.navigateToSignUp();
        signup.fillFirstNameLastNameEmail(GenerateData.firstName(),GenerateData.lastName(),GenerateData.email());
        LandingPage lp = signup.fillPasswordForm(GenerateData.password());
        Assert.assertTrue(lp.isVisibleBtn());
    }
}
