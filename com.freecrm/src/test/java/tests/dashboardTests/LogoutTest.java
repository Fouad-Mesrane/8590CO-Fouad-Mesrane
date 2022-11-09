package tests.dashboardTests;

import base.BasePage;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import utils.TestDataReader;

public class LogoutTest extends BasePage {


    @Test
    public void logoutValidationTest(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.toLoginPage();
        DashboardPage dashboard = loginPage.authentication(TestDataReader.readTestData().getProperty("email"),TestDataReader.readTestData().getProperty("password"));
        dashboard.logout();

    }
}