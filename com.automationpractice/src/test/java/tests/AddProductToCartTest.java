package tests;

import base.BasePage;
import config.BaseConfig;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.SearchResultsPage;

public class AddProductToCartTest extends BasePage {


    @Test
    public void addToCart(){
        HomePage homePage = new HomePage();
        homePage.authentication(BaseConfig.properties.getProperty("email"),BaseConfig.properties.getProperty("password") );
        SearchResultsPage searchResultsPage = homePage.search("dress");
        searchResultsPage.addToCart("Printed Chiffon Dress");

    }
}