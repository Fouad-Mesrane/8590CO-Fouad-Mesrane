package tests;

import PageObjectLibrary.CruisesPage;
import PageObjectLibrary.HomePage;
import PageObjectLibrary.SearchCruisesResults;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCruisesTest extends BasePage {


    @Test
    public void validateCruiseSearch() {
        HomePage homePage = new HomePage();
        CruisesPage cruisesPage = homePage.toCruisesPage();
        SearchCruisesResults results = cruisesPage.searchCruises();
        Assert.assertTrue(results.validateCruiseSearch());

    }
}
