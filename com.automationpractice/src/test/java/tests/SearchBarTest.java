package tests;

import base.BasePage;
import config.BaseConfig;
import org.testng.annotations.Test;
import pageObject.HomePage;

public class SearchBarTest extends BasePage {



    @Test
    public void search() {

        HomePage homePage = new HomePage();
        homePage.search(BaseConfig.properties.getProperty("search"));


    }
}