package PageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelsResults extends BasePage {

    public SearchHotelsResults(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "a[role='button']")
    WebElement viewInMapBtn;


    public boolean validateSearchHotels(){
        return isElementVisible(viewInMapBtn);
    }
}
