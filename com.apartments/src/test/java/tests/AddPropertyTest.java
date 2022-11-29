package tests;

import base.BasePage;
import org.testng.annotations.Test;
import pageObjectLibrary.AddPropertyPage;
import pageObjectLibrary.HomePage;
import utils.TestDataReader;

public class AddPropertyTest extends BasePage {
    @Test
    public void validateAddProperty() {
        HomePage homePage = new HomePage();
        AddPropertyPage add = homePage.navigateToAddProperty();
        add.addProperty(getAddress());
        // it won't let me proceed with an invalid address and same for a valid address as well (already exists)

    }

    private String getAddress() {
        // it does not accept random address so i used a valid one
        //GenerateData.streetAddress() + ", " + GenerateData.city() + ", " + GenerateData.state();
        String address = TestDataReader.getTestData().getProperty("streetAddress") + ", " + TestDataReader.getTestData().getProperty("city")
                + ", " + TestDataReader.getTestData().getProperty("state");
        return address;
    }


}
