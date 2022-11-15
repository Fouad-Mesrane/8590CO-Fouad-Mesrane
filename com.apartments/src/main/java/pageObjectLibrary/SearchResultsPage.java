package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage extends BasePage {
    public SearchResultsPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"map-container\"]/div/div/div[2]/div[2]")
    WebElement map;

    public boolean validateSearchResult(){
        return isElementVisible(map);
    }
}
