package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchResultsPage;

public class SearchBarTest extends BasePage {

    @Test
    public void validateSearch() throws InterruptedException {
        HomePage homePage = new HomePage();
        SearchResultsPage results = homePage.doSearch();
        Assert.assertTrue(results.validateSearchResult());
    }
}
