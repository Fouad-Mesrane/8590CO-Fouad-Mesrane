package pageObjectLibrary;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends BasePage {
    public LandingPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#leftPanel > ul > li:nth-child(8) > a")
    WebElement logoutBtn;
    @FindBy(xpath = "//*[@id=\"accountTable\"]/tbody/tr[4]/td[2]/b")
    WebElement totalAmount;
    @FindBy(css = "a[href='/parabank/openaccount.htm']")
    WebElement openNewAccLink;
    @FindBy(css = "#type")
    WebElement accType;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/form/div/input")
    WebElement openNewAccBtn;
    @FindBy(xpath = "//p[normalize-space()='Congratulations, your account is now open.']")
    WebElement newAccConfirmation;
    By newAccLink = By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a");



    public boolean validateLoginAndRegistration(){
       return isElementVisible(totalAmount);
    }
    public void newAccount(String accountType) throws InterruptedException {
       Thread.sleep(1000);
        clickOnElement(getClickableElement(newAccLink));
        if (accountType.equalsIgnoreCase("checking")){
            selectFromDropdownByValue(accType,"0");
        }else if (accountType.equalsIgnoreCase("savings")){
            selectFromDropdownByValue(accType,"1");
        }
        Thread.sleep(1000);
        clickOnElement(openNewAccBtn);

    }

    public String validateNewAcc(){
        waitForEleToBeVisible(newAccConfirmation);
        String confirmation = newAccConfirmation.getText();
        return confirmation;
    }

    public void logout() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(getClickableElement(By.cssSelector("#leftPanel > ul > li:nth-child(8) > a")));

    }


}
