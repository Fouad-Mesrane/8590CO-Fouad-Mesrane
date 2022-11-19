package tests;

import PageObjectLibrary.HomePage;
import PageObjectLibrary.SearchHotelsResults;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchHotelsTest extends BasePage {

    @Test
    public void validateHotelsSearch() throws InterruptedException {
        HomePage homePage = new HomePage();
        SearchHotelsResults results = homePage.searchHotels();
        Assert.assertTrue(results.validateSearchHotels());


    }
}
