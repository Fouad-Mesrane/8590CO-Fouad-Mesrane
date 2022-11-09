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

import java.io.File;

public class SubmitOrderTest extends BasePage {


    @Test(dataProvider = "credentials")
    public void submitOrder(String email, String password) {
        HomePage homePage = new HomePage();
        homePage.authentication(email, password);
        SearchResultsPage searchResults = homePage.search(BaseConfig.properties.getProperty("search"));
        CartPage cart = searchResults.addToCart(BaseConfig.properties.getProperty("product"));
        boolean match = cart.verifyProductDisplay(BaseConfig.properties.getProperty("product"));
        Assert.assertTrue(match);
        OrderReceiptPage orderReceipt = cart.checkout();
        boolean confirm = orderReceipt.validateOrderConfirmation();
        Assert.assertTrue(confirm);
        homePage.signOut();



    }


    @DataProvider(name = "credentials")
    public Object[][] getCredentialsData() {
        String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "automation_practice_credentials.xlsx";
        ExcelData dataFromExcel = new ExcelData(filePath);
        Object[][] data = dataFromExcel.readStringArrays("LoginCredentials");
        return data;
    }


}
