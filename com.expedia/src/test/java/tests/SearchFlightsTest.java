package tests;

import PageObjectLibrary.FlightsPage;
import PageObjectLibrary.HomePage;
import PageObjectLibrary.SearchFlightsResults;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFlightsTest extends BasePage {

    @Test
    public void validateSearchFlights() throws InterruptedException {
        HomePage homePage = new HomePage();
        FlightsPage flights = homePage.toFlightsPage();
        SearchFlightsResults results = flights.searchFlights();
        Assert.assertTrue(results.validateFlightSearchResult());
    }
}
