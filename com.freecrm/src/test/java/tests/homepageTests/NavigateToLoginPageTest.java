package tests.homepageTests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

public class NavigateToLoginPageTest extends BasePage {


    @Test
    public void goToLoginPage(){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.toLoginPage();
        boolean match = loginPage.validateLoginPage();
        Assert.assertTrue(match);
    }
}