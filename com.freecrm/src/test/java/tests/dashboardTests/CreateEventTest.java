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

public class CreateEventTest extends BasePage {

    @Test(dataProvider = "getData", dataProviderClass = AuthenticationTest.class)
    public void validateEventCreation(HashMap<String,String> input)  {
        HomePage homePage = new HomePage();
        LoginPage login = homePage.toLoginPage();
        DashboardPage dashboard = login.authentication(input.get("email"), input.get("password"));
        dashboard.createEvent(TestDataReader.getTestData().getProperty("title"));
        Assert.assertEquals(dashboard.validateEventCreated(),TestDataReader.getTestData().getProperty("title"));
    }
}