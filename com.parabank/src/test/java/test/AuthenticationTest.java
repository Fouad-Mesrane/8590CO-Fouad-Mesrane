package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import utils.ExcelData;
import utils.GenerateData;
import utils.TestDataReader;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class AuthenticationTest extends BasePage {

    @Test(dataProvider = "credentials",priority = 1)
    public void validateLogin(String username, String password) throws SQLException, IOException {
        HomePage homePage = new HomePage();
        // used credentials from database
        LandingPage landingPage = homePage.authentication(username,password);
        //Assert.assertTrue(landingPage.validateRegistration());
    }

    @Test(priority = 2)
    public void validateErrorLogin() {
        HomePage homePage = new HomePage();
        LandingPage landingPage = homePage.errorLogin(GenerateData.firstName(),GenerateData.password());
        Assert.assertEquals(landingPage.validateErrorLoginMsg(), TestDataReader.getTestData().getProperty("expected.errorLoginMsg"));
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredentialsData(){
        String filePath = System.getProperty("user.dir") + File.separator+ "src" + File.separator+ "main" +File.separator + "resources" +
                File.separator + "data" + File.separator + "credentials_parabank.xlsx";
        ExcelData dataFromExcel = new ExcelData(filePath);
        Object[][] data = dataFromExcel.readStringArrays("LoginCredentials");
        return data;
    }
}
