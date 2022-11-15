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

import java.io.File;

public class CheckoutTest extends BasePage {

    @Test(dataProvider = "getCredentialsData")
    public void submitOrder(String email, String password){
        HomePage homePage = new HomePage();
        homePage.authentication(email,password );
        SearchResultsPage searchResultsPage = homePage.search("dress");
        CartPage cartPage = searchResultsPage.addToCart("Printed Chiffon Dress");
        OrderReceiptPage orderReceiptPage = cartPage.checkout();
        boolean match = orderReceiptPage.validateOrderConfirmation();

        Assert.assertTrue(match);


    }

    @DataProvider
    public  Object[][] getCredentialsData(){
        String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "automation_practice_credentials.xlsx";
        ExcelData dataFromExcel = new ExcelData(filePath);
        Object[][] data = dataFromExcel.readStringArrays("LoginCredentials");
        return data;
    }
}
