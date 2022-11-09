package tests.loginTests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectModel.DashboardPage;
import pageObjectModel.HomePage;
import pageObjectModel.LoginPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class AuthenticationTest extends BasePage {


    @Test(dataProvider = "getData")
    public void login(HashMap<String,String> input){
        HomePage homePage = new HomePage();
        LoginPage loginPage = homePage.toLoginPage();
        DashboardPage dashboard = loginPage.authentication(input.get("email"), input.get("password"));
        Assert.assertTrue(dashboard.validateLogin());

    }


    @DataProvider
    public Object[][] getData(){
        List<HashMap<String,String>> data;
        try {
            data = getJasonDataToMap(System.getProperty("user.dir") + "\\src\\main\\resources\\data\\credentials.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new Object[][]{ {data.get(0)}};
    }
}