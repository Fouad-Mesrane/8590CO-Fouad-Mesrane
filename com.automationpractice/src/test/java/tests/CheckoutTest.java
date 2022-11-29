package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.OrderReceiptPage;
import pageObject.SearchResultsPage;
import utils.ExcelData;
import utils.TestDataReader;

import java.io.File;

public class CheckoutTest extends BasePage {

    @Test(dataProvider = "getCredentialsData", dataProviderClass = AuthenticationTest.class)
    public void submitOrder(String email, String password){
        HomePage homePage = new HomePage();
        homePage.authentication(email,password);
        SearchResultsPage searchResultsPage = homePage.search(TestDataReader.properties.getProperty("search"));
        CartPage cartPage = searchResultsPage.addToCart(TestDataReader.getTestData().getProperty("product"));
        OrderReceiptPage orderReceiptPage = cartPage.checkout();
        boolean match = orderReceiptPage.validateOrderConfirmation();

        Assert.assertTrue(match);


    }


}
