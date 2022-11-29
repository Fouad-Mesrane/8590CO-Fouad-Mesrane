package tests;

import base.BasePage;
import config.BaseConfig;
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

public class SubmitOrderTest extends BasePage {


    @Test(dataProvider = "credentials",dataProviderClass = AuthenticationTest.class)
    public void submitOrder(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.authentication(email, password);
        SearchResultsPage searchResults = homePage.search(TestDataReader.getTestData().getProperty("search"));
        CartPage cart = searchResults.addToCart(TestDataReader.getTestData().getProperty("product"));
        OrderReceiptPage orderReceipt = cart.checkout();
        boolean confirm = orderReceipt.validateOrderConfirmation();
        Assert.assertTrue(confirm);
        homePage.signOut();



    }





}
