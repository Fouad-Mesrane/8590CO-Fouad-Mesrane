package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPageResults extends BasePage {
    public SearchPageResults(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".s-item__info > a")
    List<WebElement> resultsList;


    public boolean validateSearchResults(){
        return isElementVisible( resultsList.get(1));
    }

    public SelectedProductPage selectProduct(){
        int n =(int) (Math.random() * resultsList.size() -1 )  ;
        clickOnElement(resultsList.get(n));
        switchToTab();
        return new SelectedProductPage();
    }
}
