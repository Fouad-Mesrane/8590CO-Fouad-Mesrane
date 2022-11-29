package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import pageObjectLibrary.RegistrationPage;
import utils.TestDataReader;

public class RegistrationTest extends BasePage {

    @Test
    public void validateRegistration(){
        HomePage homePage = new HomePage();
        RegistrationPage registration = homePage.navigateToRegistrationPage();
        LandingPage landingPage = registration.fillRegistrationForm();
        Assert.assertEquals(landingPage.validateRegistration(), TestDataReader.getTestData().getProperty("expected.accountCreationMsg"));
    }
}
