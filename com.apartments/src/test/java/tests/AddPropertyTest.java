package tests;

import base.BasePage;
import org.testng.annotations.Test;
import pageObjectLibrary.AddPropertyPage;
import pageObjectLibrary.HomePage;

public class AddPropertyTest extends BasePage {
    @Test
    public void validateAddProperty() {
        HomePage homePage = new HomePage();
        AddPropertyPage add = homePage.navigateToAddProperty();
        add.addProperty();
        // it won't let me proceed with an invalid address and same for a valid address as well (already exists)

    }


}
