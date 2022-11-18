package tests;

import base.BasePage;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;

public class ChangeLanguageTest extends BasePage {
    @Test
    public  void validateLanguageChange(){
        HomePage homePage = new HomePage();
        homePage.changeLanguage();
    }
}
