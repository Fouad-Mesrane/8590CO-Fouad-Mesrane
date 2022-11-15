package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import pageObjectLibrary.SignupPage;

public class SignupTest extends BasePage {

    @Test
    public void validateSignup() throws InterruptedException {
        HomePage homePage = new HomePage();
        SignupPage signup = homePage.navigateToSignUp();
        LandingPage landingPage = signup.createAcc();
        Assert.assertTrue(landingPage.isVisibleBtn());
    }
}
