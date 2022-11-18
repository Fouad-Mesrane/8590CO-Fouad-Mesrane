package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchPageResults;

public class SearchBarTest extends BasePage {

    @Test
    public void validateWorkingOfSearchFunctionality() {
        HomePage homePage = new HomePage();
        SearchPageResults results = homePage.doSearch();
        Assert.assertTrue(results.validateSearchResults());
    }
}
