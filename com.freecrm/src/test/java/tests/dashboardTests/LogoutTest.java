package tests.dashboardTests;

import base.BasePage;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import tests.loginTests.AuthenticationTest;
import utils.TestDataReader;

import java.util.HashMap;

public class LogoutTest extends BasePage {


    @Test(dataProvider = "getData", dataProviderClass = AuthenticationTest.class)
    public void logoutValidationTest(HashMap<String,String> input){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.toLoginPage();
        DashboardPage dashboard = loginPage.authentication(input.get("email"), input.get("password"));
        dashboard.logout();

    }
}