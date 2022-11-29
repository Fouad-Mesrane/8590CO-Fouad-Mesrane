package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

import java.util.List;

public class AddPropertyPage extends BasePage {
    public AddPropertyPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "iframeAddProperty")
    WebElement addPropertyFrame;
    @FindBy(xpath = "//input[@id='cpid1-address']")
    WebElement addressField;
    @FindBy(css = "#mat-autocomplete-0")
    WebElement autoCompleteAddressContainer;
    @FindBy(css = "#mat-autocomplete-0 > mat-option")
    List<WebElement> autoCompleteOptions;
    @FindBy(xpath = "//mat-select[@id='cpid1-propertyType']")
    WebElement selectBtn;

    @FindBy(css = "#cpid1-propertyType-panel")
    WebElement propertySelectContainer;

    @FindBy(css = "#cpid1-propertyType-panel > mat-option")
    List<WebElement> propertyType;

    public void addProperty(String address) {
        waitForEleToBeVisible(addPropertyFrame);
        switchToFrameByElement(addPropertyFrame);
        sendKeysToElement(addressField,address);
        waitForEleToBeVisible(autoCompleteAddressContainer);
        clickOnElement(autoCompleteOptions.get(0));
        clickOnElement(selectBtn);
        waitForEleToBeVisible(propertySelectContainer);
        clickOnElement(propertyType.get(1));
    }


}