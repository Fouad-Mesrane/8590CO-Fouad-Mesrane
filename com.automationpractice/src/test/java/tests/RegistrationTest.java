package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.LandingPage;
import pageObject.RegistrationPage;
import utils.GenerateData;
import utils.TestDataReader;

public class RegistrationTest extends BasePage {

    @Test
    public void registerAnAcct(){
        HomePage homePage = new HomePage();
        RegistrationPage registrationPage = homePage.toRegistrationPage();
        registrationPage.fillRegistrationFormFirstPart(GenerateData.firstName(),GenerateData.lastName(),GenerateData.password());
        registrationPage.dob(TestDataReader.getTestData().getProperty("day"),TestDataReader.getTestData().getProperty("month"),TestDataReader.getTestData().getProperty("year") );
        registrationPage.fillAddressPart();
        LandingPage lp = registrationPage.doRegistration();
        Boolean match = lp.validateVisibleElement();

        Assert.assertTrue(match);



    }
}
