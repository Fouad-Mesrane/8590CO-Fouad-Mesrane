package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectedCarouselPage extends BasePage {
    public SelectedCarouselPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "/html/body/div[4]/div[2]")
    WebElement pageContainer;

    public boolean validateShowingTitle(){
        return isElementVisible(pageContainer);
    }

}
