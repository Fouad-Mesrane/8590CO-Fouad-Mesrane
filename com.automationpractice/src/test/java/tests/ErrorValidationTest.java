package tests;

import base.BasePage;
import config.BaseConfig;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.SearchResultsPage;
import utils.GenerateData;
import utils.TestDataReader;

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


    @Test(dataProvider = "getCredentialsData", dataProviderClass = AuthenticationTest.class)
    public void productErrorValidation(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.authentication(email,password);
        SearchResultsPage searchResultsPage = homePage.search(TestDataReader.properties.getProperty("search"));
        CartPage cartPage = searchResultsPage.addToCart(TestDataReader.properties.getProperty("product"));
        boolean match =  cartPage.verifyProductDisplay("Printed Chiffon Dress");
        Assert.assertFalse(match);

    }
}