package tests;

import PageObjectLibrary.HomePage;
import PageObjectLibrary.LandingPage;
import PageObjectLibrary.SignupPage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignupTest extends BasePage {

    @Test
    public void validateSignup(){
        HomePage homePage = new HomePage();
        SignupPage signup = homePage.toSignupPage();
        LandingPage landingPage = signup.register();
        Assert.assertTrue(landingPage.validateSignupAndSignin());
    }






}
