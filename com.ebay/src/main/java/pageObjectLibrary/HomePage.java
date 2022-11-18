package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.TestDataReader;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    // ================= Search Bar Locators =====================
    @FindBy(xpath = "//input[@id='gh-ac']")
    WebElement searchBarInput;
    @FindBy(xpath = "//input[@id='gh-btn']")
    WebElement searchBtn;
    @FindBy(css = ".gf-flags-wpr > a ")
    WebElement mainLanguage;

    @FindBy(css = ".gf-ful>li>a")
    List<WebElement> languages;

    //================= Carousel Locators ===================
    @FindBy(css = ".hl-banner__text >h2 > a")
    List<WebElement> carouselList;

    @FindBy(xpath = "//button[@aria-label='Pause Banner Carousel']")
    WebElement pauseSliderBtn;
    @FindBy(xpath = "//button[@aria-label='Play Banner Carousel']")
    WebElement playSliderBtn;
    @FindBy(xpath = "//button[@aria-label='Go to next banner']")
    WebElement nextBannerBtn;
    @FindBy(xpath = "//button[@aria-label='Go to previous banner']")
    WebElement previousBannerBtn;


    public SearchPageResults doSearch() {
        sendKeysToElement(searchBarInput, TestDataReader.readTestData().getProperty("search.term"));
        clickOnElement(searchBtn);
        return new SearchPageResults();
    }

    public void changeLanguage() {
        int n = (int) (Math.random() * languages.size() - 1);
        WebElement ele = languages.get(n);

        scrollDown();
        hoverOverElement(mainLanguage);

        clickOnElement(ele);


    }

    public SelectedCarouselPage selectBanner() {
        WebElement carouselAd = carouselList.get(0);
        pauseBanner();
        while (!(isElementVisible(carouselAd))) {
            clickOnElement(nextBannerBtn);

        }
        clickOnElement(carouselAd);
        return new SelectedCarouselPage();
    }

    public void pauseBanner() {
        clickOnElement(pauseSliderBtn);

    }

    public void playBanner() {

        clickOnElement(playSliderBtn);

    }

    public boolean validatePauseBtn() {
        return isElementVisible(playSliderBtn);
    }

    public void nextBanner() {
        pauseBanner();
        clickOnElement(nextBannerBtn);

    }

    public void previousBanner() {
        pauseBanner();
        clickOnElement(previousBannerBtn);
    }

    private void scrollDown() {
        jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript("window.scroll(0,1500);");
    }
}
