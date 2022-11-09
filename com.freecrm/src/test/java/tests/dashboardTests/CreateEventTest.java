package tests.dashboardTests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import utils.TestDataReader;

public class CreateEventTest extends BasePage {

    @Test
    public void validateEventCreation()  {
        HomePage homePage = new HomePage();
        LoginPage login = homePage.toLoginPage();
        DashboardPage dashboard = login.authentication(TestDataReader.readTestData().getProperty("email"), TestDataReader.readTestData().getProperty("password"));
        dashboard.createEvent(TestDataReader.readTestData().getProperty("title"));
        Assert.assertEquals(dashboard.validateEventCreated(),TestDataReader.readTestData().getProperty("title"));
    }
}