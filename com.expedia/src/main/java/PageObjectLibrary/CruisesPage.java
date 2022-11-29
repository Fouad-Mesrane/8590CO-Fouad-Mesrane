package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

public class CruisesPage extends BasePage {
    public CruisesPage(){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//select[@id='cruise-destination']")
    WebElement selectDestination;

    public SearchCruisesResults searchCruises(){
        selectFromDropdownByValue(selectDestination, TestDataReader.getTestData().getProperty("destination"));
        clickOnElement(HomePage.checkInDate);
        waitForEleToBeVisible(HomePage.monthYear);
        //departure date
        // checking date
        HomePage.datePicker(TestDataReader.properties.getProperty("departure.day"), TestDataReader.properties.getProperty("departure.month"), TestDataReader.properties.getProperty("departure.year"));
        //checkout date
        HomePage.datePicker(TestDataReader.properties.getProperty("returning.day"), TestDataReader.properties.getProperty("returning.month"), TestDataReader.properties.getProperty("returning.year"));
        clickOnElement(HomePage.applyDatePickerBtn);
        clickOnElement(HomePage.searchBtn);

        return new SearchCruisesResults();
    }

}
