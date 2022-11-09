package tests;

import base.BasePage;
import config.BaseConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.SearchResultsPage;
import utils.GenerateData;

public class ErrorValidationTest extends BasePage {

    @Test
    public void loginErrorValidation() {

        HomePage homePage = new HomePage();
        homePage.authentication(GenerateData.email(), GenerateData.password());
        Assert.assertEquals(homePage.getLoginErrorMessage(), "There is 1 error");

    }

    @Test
    public void existingEmailValidation() {
        HomePage homePage = new HomePage();
        String existingEmailMsg = homePage.getexistingEmailErrorMessage(BaseConfig.properties.getProperty("email"));
        Assert.assertEquals(existingEmailMsg, "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }


    @Test
    public void productErrorValidation() {
        HomePage homePage = new HomePage();
        homePage.authentication(BaseConfig.properties.getProperty("email"),BaseConfig.properties.getProperty("password"));
        SearchResultsPage searchResultsPage = homePage.search("dress");
        CartPage cartPage = searchResultsPage.addToCart("Printed Chiffon Dress");
        boolean match =  cartPage.verifyProductDisplay("Printed Chiffon Dress");
        Assert.assertFalse(match);

    }
}