package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchResultsPage;
import utils.TestDataReader;

public class SearchBarTest extends BasePage {

    @Test
    public void validateSearch() throws InterruptedException {
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.doSearch(TestDataReader.getTestData().getProperty("city"));
        Assert.assertTrue(results.validateSearchResult());
    }
}
