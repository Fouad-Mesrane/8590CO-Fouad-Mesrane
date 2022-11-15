package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import pageObjectLibrary.RegistrationPage;

public class RegistrationTest extends BasePage {

    @Test
    public void validateRegistration(){
        HomePage homePage = new HomePage();
        RegistrationPage registration = homePage.navigateToRegistrationPage();
        LandingPage landingPage = registration.fillRegistrationForm();
        Assert.assertTrue(landingPage.validateLoginAndRegistration());
    }
}
