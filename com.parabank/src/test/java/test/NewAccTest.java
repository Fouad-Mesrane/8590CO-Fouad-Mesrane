package test;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.LandingPage;
import utils.TestDataReader;

import java.io.IOException;
import java.sql.SQLException;

public class NewAccTest extends BasePage {

    @Test(dataProvider = "credentials",dataProviderClass = AuthenticationTest.class)
    public void validateCreationOfNewAcc(String username, String password) throws SQLException, IOException, InterruptedException {
        HomePage homePage = new HomePage();
        // used credentials from database
        LandingPage landingPage = homePage.authentication(username,password);
        landingPage.newAccount("Checking");
        Assert.assertEquals(landingPage.validateNewAcc(), TestDataReader.getTestData().getProperty("expected.newBankAccountMsg"));
    }
}
