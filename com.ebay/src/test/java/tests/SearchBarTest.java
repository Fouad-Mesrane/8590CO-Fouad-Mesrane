package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchPageResults;
import utils.TestDataReader;

public class SearchBarTest extends BasePage {

    @Test
    public void validateWorkingOfSearchFunctionality() {
        HomePage homePage = new HomePage();
        SearchPageResults results = homePage.doSearch(TestDataReader.readTestData().getProperty("search.term"));
        Assert.assertTrue(results.validateSearchResults());
    }
}
