package tests.dashboardTests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import tests.loginTests.AuthenticationTest;
import utils.TestDataReader;

import java.util.HashMap;

public class DeleteContactValidationTest extends BasePage {


    @Test(dataProvider = "getData", dataProviderClass = AuthenticationTest.class)
    public void validateDeleteContact(HashMap<String,String> input) throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage login = homePage.toLoginPage();
        DashboardPage dashboard = login.authentication(input.get("email"), input.get("password"));


        boolean match = dashboard.deleteContactValidation();
        System.out.println(match);
        Assert.assertTrue(match);


    }
}