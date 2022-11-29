package tests;

import base.BasePage;
import config.BaseConfig;
import org.testng.annotations.Test;
import pageObject.HomePage;
import utils.TestDataReader;

public class SearchBarTest extends BasePage {



    @Test
    public void search() {

        HomePage homePage = new HomePage();
        homePage.search(TestDataReader.getTestData().getProperty("search"));
        // account got suspended so i cannot assert


    }
}