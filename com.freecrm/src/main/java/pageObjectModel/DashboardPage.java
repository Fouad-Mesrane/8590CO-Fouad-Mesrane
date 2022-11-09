package pageObjectModel;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.GenerateData;

import java.util.List;

public class DashboardPage extends BasePage {

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    // left side menu buttons
    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[1]/a/i")
    WebElement homeIcon;

    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/a/i")
    WebElement contactBtn;

    @FindBy(xpath = "//*[@id=\"main-nav\"]/div[2]/a")
    WebElement calendarBtn;
    // contact page
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
    WebElement createContactBtn;

    @FindBy(css = "input[name='first_name']")
    WebElement firstNameField;
    @FindBy(css = "input[name='last_name']")
    WebElement lastNameField;

    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[1]/div/div/i")
    WebElement statusDropDownMenuBtn;
    @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[1]/div/div/div[2]/div")
    List<WebElement> statusDropDownMenu;
    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
    WebElement saveBtn;

    @FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
    WebElement newContactName;

    // deleting the contacts

    @FindBy(css = ".contents>button")
    List<WebElement> binIconBtns;


    @FindBy(id = "rufous-sandbox")
    WebElement frame;


    By deleteBtn = By.xpath("//button[normalize-space()='Delete']");

    // calendar page (event creation)

    @FindBy(xpath = "//button[normalize-space()='Create']")
    WebElement createEventBtn;

    @FindBy(css = "input[name='title']")
    WebElement titleField;
    @FindBy(xpath = "//div[@name='category']//i[@class='dropdown icon']")
    WebElement categoryDropDownMenuBtn;
    @FindBy(css = ".visible.menu.transition > div")
    List<WebElement> categoryDropDownMenu;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveEventBtn;
    @FindBy(css = "div[class='field'] div div span p")

    WebElement verifyTitle;

    // logout region
    @FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/div[2]/div/i")
    WebElement settingsIcon;
    @FindBy(xpath = "//div[@class='ui buttons']//a[5]")
    WebElement logoutBtn;


    String firstName = GenerateData.firstName();
    String lastName = GenerateData.lastName();

    public boolean validateLogin() {
        boolean match = isElementVisible(homeIcon);
        return match;
    }

    // add contact region
    public void addContact() {

        clickOnElement(contactBtn);
        clickOnElement(createContactBtn);
        fillContactForm();
        clickOnElement(saveBtn);
    }

    public void fillContactForm() {
        sendKeysToElement(firstNameField, firstName);
        sendKeysToElement(lastNameField, lastName);
        clickOnElement(statusDropDownMenuBtn);
        clickOnElement(getStatus("Active"));
    }

    public WebElement getStatus(String status) {
        WebElement ele = statusDropDownMenu.stream().filter(statusDropDown ->
                statusDropDown.getText().equalsIgnoreCase(status)).findFirst().orElse(null);
        return ele;
    }

    public boolean validateContactAdded() {
        return isElementVisible(newContactName);
    }

    public boolean deleteContactValidation() throws InterruptedException {
        clickOnElement(contactBtn);
        WebElement firstEle = webDriverWait.until(ExpectedConditions.visibilityOfAllElements(binIconBtns)).get(0);

        int sizeBeforeDeletion = binIconBtns.size();

        clickOnElement(firstEle);
        getVisibleElement(deleteBtn).click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElements(binIconBtns));
        int sizeAfterDeletion = binIconBtns.size();

        if (sizeBeforeDeletion - 1 == sizeAfterDeletion) {
            return true;
        }
        return false;

    }

    // end region

    // add event region

    public void createEvent(String title) {
        clickOnElement(calendarBtn);
        clickOnElement(createEventBtn);
        sendKeysToElement(titleField, title);
        clickOnElement(categoryDropDownMenuBtn);
        clickOnElement(getCategory("Meeting"));
        clickOnElement(saveEventBtn);

    }

    public WebElement getCategory(String category) {
        WebElement ele = categoryDropDownMenu.stream().filter(categoryDropDown ->
                categoryDropDown.getText().equalsIgnoreCase(category)).findFirst().orElse(null);
        return ele;
    }

    public String validateEventCreated() {

        String ele = webDriverWait.until(ExpectedConditions.visibilityOf(verifyTitle)).getText();
        return ele;

    }

    // logout
    public LoginPage logout(){
        clickOnElement(settingsIcon);
        clickOnElement(logoutBtn);
        return new LoginPage();

    }


}