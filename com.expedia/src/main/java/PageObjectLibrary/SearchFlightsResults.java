package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchFlightsResults extends BasePage {
    public SearchFlightsResults(){
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]/div[2]/div[3]/div[1]/section/main/ul/li")
    List<WebElement> flightsResultsList;


    public boolean validateFlightSearchResult(){
        return isElementVisible(flightsResultsList.get(0));
    }
}
