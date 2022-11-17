package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCruisesResults extends BasePage {
    public SearchCruisesResults(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"app-layer-base\"]/div/div[2]/div/div[1]/div[3]/div[2]/div[3]/div[2]/div/a")
    List<WebElement> searchResults;

    public boolean validateCruiseSearch(){
        return isElementVisible(searchResults.get(0));
    }
}
