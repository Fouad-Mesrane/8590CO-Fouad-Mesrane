package tests;

import PageObjectLibrary.HomePage;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.TestDataReader;

public class ChangeLanguageTest extends BasePage {

    @Test
    public void validateLanguageChange(){
        HomePage homePage = new HomePage();
        homePage.changeLanguage();
        Assert.assertEquals(homePage.validateLanguageChanged(), TestDataReader.readTestData().getProperty("expected"));
    }
}
