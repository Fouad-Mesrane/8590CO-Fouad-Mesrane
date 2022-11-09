package tests.loginTests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;
import utils.GenerateData;

public class ErrorLoginValidationTest extends BasePage {

    @Test

    public void loginErrorValidation(){
        HomePage homePage = new HomePage();
        LoginPage login = homePage.toLoginPage();
        login.authentication(GenerateData.email(),GenerateData.password());
        boolean match = login.validateErrorLoginMsg();
        Assert.assertTrue(match);

    }
}

