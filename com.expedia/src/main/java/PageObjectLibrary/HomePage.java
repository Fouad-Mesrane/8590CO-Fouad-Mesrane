package PageObjectLibrary;

import base.BasePage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.TestDataReader;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    static String monthYearVal;

    // ==================== Header Buttons ================
    // language locators
    @FindBy(xpath = "(//button[@type='button'])[4]")
    WebElement signinHeader;
    @FindBy(xpath = "//*[@id=\"app-layer-base\"]/div[1]/div[1]/header/div/section/div/div/div/a")
    WebElement signinIcon;
    @FindBy(xpath = "(//a[contains(text(),'Sign up, it’s free')])[1]")
    WebElement signupBtn;
    @FindBy(xpath = "(//a[normalize-space()='Sign in'])[1]")
    WebElement signinBtn;
    @FindBy(css = "button[class='uitk-button uitk-button-medium uitk-button-tertiary global-navigation-nav-button']")
    WebElement languageBtn;
    @FindBy(xpath = "//select[@id='language-selector']")
    WebElement languageSelector;
    @FindBy(css = "div[class='uitk-scrim fade-button'] button[type='button']")
    WebElement saveBtn;
    //========================== choices ==============================
    @FindBy(css = ".uitk-tab-anchor[href='?pwaLob=wizard-flight-pwa']")
    WebElement flights;
    @FindBy(xpath = "//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[6]/a")
    WebElement cruises;





    /*===================== Find Hotels Locators ================*/

    @FindBy(xpath = "//*[@id=\"wizardMainRegionV2\"]/div/div/div/div/ul/li[1]/a")
    WebElement stays;
    @FindBy(xpath = "//button[@aria-label='Going to']")
    WebElement destinationBtn;
    @FindBy(xpath = "//input[@id='location-field-destination']")
    WebElement destinationInput;
    @FindBy(css = ".no-bullet > li > button")
    List<WebElement> destinationsDropDown;
    @FindBy(css = "#d1-btn")
    static WebElement checkInDate;
    @FindBy(xpath = "(//h2[@class='uitk-date-picker-month-name uitk-type-medium'])[1]")
    static WebElement monthYear;
    @FindBy(css = "div[class='uitk-calendar'] button:nth-child(2)")
    static WebElement nextBtn;

    @FindBy(xpath = "(//tbody)[1]/tr/td/button")
    static List<WebElement> days;
    @FindBy(css = "button[class='uitk-button uitk-button-medium uitk-button-has-text uitk-button-primary']")
    static WebElement applyDatePickerBtn;
    @FindBy(css = "button[data-testid='submit-button']")
    static WebElement searchBtn;

    //======================== Sign Up ===============================

    public SignupPage toSignupPage() {

        clickOnElement(signinIcon);
        clickOnElement(signupBtn);

        return new SignupPage();
    }

    //================= Login ===================
    public SignInPage toSignInPage() {

        // clickOnElement(signinHeader);
        clickOnElement(signinBtn);

        return new SignInPage();
    }


    // =========== navigate to search lights page ============
    public FlightsPage toFlightsPage() {
        clickOnElement(flights);
        return new FlightsPage();
    }

    // ========== navigate to cruises page =============
    public CruisesPage toCruisesPage() {
        clickOnElement(cruises);
        return new CruisesPage();
    }


    public SearchHotelsResults searchHotels() throws InterruptedException {
        String city = TestDataReader.getTestData().getProperty("city");
        clickOnElement(destinationBtn);
        sendKeysToElement(destinationInput, city);
        waitForElementsToBeVisible(destinationsDropDown);
        Thread.sleep(1000);
        WebElement firstEle = destinationsDropDown.get(0);
        if (firstEle.getText().contains(city)) {
            clickOnElement(firstEle);
        }
        clickOnElement(checkInDate);
        waitForEleToBeVisible(monthYear);
        // checking date
        datePicker(TestDataReader.properties.getProperty("check.in.day"), TestDataReader.properties.getProperty("check.in.month"), TestDataReader.properties.getProperty("check.in.year"));
        //checkout date
        datePicker(TestDataReader.properties.getProperty("check.out.day"), TestDataReader.properties.getProperty("check.out.month"), TestDataReader.properties.getProperty("check.out.year"));

        clickOnElement(applyDatePickerBtn);
        clickOnElement(searchBtn);

        return new SearchHotelsResults();

    }

    // a method to pick dates
    public static void datePicker(String day, String month, String year) {

        if (month.equalsIgnoreCase("february") && Integer.parseInt(day) > 29) {
            System.out.println("Wrong Date:" + month + " : " + day);
            throw new RuntimeException("Wrong Date");

        }

        if (Integer.parseInt(day) > 31) {
            System.out.println("Wrong Date:" + month + " : " + day);
            throw new RuntimeException("Wrong Date");
        }

        monthYearVal = monthYear.getText();

        while (!(getMonthYearVal(monthYearVal)[0].equalsIgnoreCase(month)
                &&
                getMonthYearVal(monthYearVal)[1].equals(year))) {
            clickOnElement(nextBtn);
            monthYearVal = monthYear.getText();
        }
        clickOnElement(days.get(Integer.parseInt(day) - 1));

    }

    private static String[] getMonthYearVal(String monthYearVal) {
        return monthYearVal.split(" ");
    }

    // change language method
    public void changeLanguage() {
        clickOnElement(languageBtn);
        selectFromDropdownByIndex(languageSelector, Integer.parseInt(TestDataReader.getTestData().getProperty("espagnol")));
        clickOnElement(saveBtn);
    }

    public String validateLanguageChanged() {
        waitForEleToBeVisible(languageBtn);
        return languageBtn.getText();
    }


}
