package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

import java.util.List;

public class FlightsPage extends BasePage {
    public FlightsPage() {
        PageFactory.initElements(driver, this);
    }

    // flights locators
    @FindBy(xpath = "//button[@aria-label='Leaving from']")
    WebElement leavingFromBtn;
    @FindBy(xpath = "//input[@id='location-field-leg1-origin']")
    WebElement airportDepartureInput;
    @FindBy(xpath = "//input[@id='location-field-leg1-destination']")
    WebElement airportDestinationInput;

    @FindBy(xpath = "(//ul[@class='no-bullet']/li/button)[1]")
    WebElement selectDepartureAirport;
    @FindBy(xpath = "//*[@id=\"location-field-leg1-destination-menu\"]/div[2]/div[2]/ul/li[1]/button")
    WebElement selectDestinationAirport;


    @FindBy(xpath = "//button[@aria-label='Going to']")
    WebElement gointToBtn;
    @FindBy(xpath = "(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")
    WebElement monthYear;




    public SearchFlightsResults searchFlights() throws InterruptedException {
        clickOnElement(leavingFromBtn);
        sendKeysToElement(airportDepartureInput, TestDataReader.getTestData().getProperty("from"));
        Thread.sleep(1000);
        clickOnElement(selectDepartureAirport);
        clickOnElement(gointToBtn);
        sendKeysToElement(airportDestinationInput,TestDataReader.getTestData().getProperty("to"));
        Thread.sleep(1000);
        jsClickOnElement(selectDestinationAirport);
        clickOnElement(HomePage.checkInDate);
        waitForEleToBeVisible(HomePage.monthYear);
        //departure date
        // checking date
        HomePage.datePicker(TestDataReader.properties.getProperty("departure.day"), TestDataReader.properties.getProperty("departure.month"), TestDataReader.properties.getProperty("departure.year"));
        //checkout date
        HomePage.datePicker(TestDataReader.properties.getProperty("returning.day"), TestDataReader.properties.getProperty("returning.month"), TestDataReader.properties.getProperty("returning.year"));
        clickOnElement(HomePage.applyDatePickerBtn);
        clickOnElement(HomePage.searchBtn);

        return new SearchFlightsResults();

    }



}
