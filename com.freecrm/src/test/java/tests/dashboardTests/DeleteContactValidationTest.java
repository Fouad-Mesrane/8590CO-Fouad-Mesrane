package tests.dashboardTests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import utils.TestDataReader;

public class DeleteContactValidationTest extends BasePage {


    @Test
    public void validateDeleteContact() throws InterruptedException {
        HomePage homePage = new HomePage();
        LoginPage login = homePage.toLoginPage();
        DashboardPage dashboard = login.authentication(TestDataReader.readTestData().getProperty("email"), TestDataReader.readTestData().getProperty("password"));


        boolean match = dashboard.deleteContactValidation();
        System.out.println(match);
        Assert.assertTrue(match);


    }
}