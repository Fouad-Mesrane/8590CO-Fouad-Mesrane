package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SearchPageResults;
import pageObjectLibrary.SelectedProductPage;

public class SelectProductTest extends BasePage {

    @Test
    public void validateSelectedProduct(){
        HomePage homePage = new HomePage();
        SearchPageResults results = homePage.doSearch();
        SelectedProductPage selectedProduct = results.selectProduct();
        Assert.assertTrue(selectedProduct.validateProductSelection());
    }
}
