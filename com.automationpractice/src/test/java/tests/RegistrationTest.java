package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LandingPage;
import pageObject.RegistrationPage;

public class RegistrationTest extends BasePage {

    @Test
    public void registerAnAcct(){
        HomePage homePage = new HomePage();
        RegistrationPage registrationPage = homePage.toRegistrationPage();
        LandingPage landingPage = registrationPage.doRegistration();
        Boolean match = landingPage.validateVisibleElement();

        Assert.assertTrue(match);



    }
}
