package tests;

import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectLibrary.HomePage;
import pageObjectLibrary.SelectedCarouselPage;

public class CarouselTest extends BasePage {

    @Test(priority = 1)
    public void validateCarouselLink(){
        HomePage hp = new HomePage();
        SelectedCarouselPage scp =  hp.selectBanner();
        Assert.assertTrue(scp.validateShowingTitle());
    }
    @Test
    public void pauseSliderTest(){
        HomePage hp = new HomePage();
        hp.pauseBanner();
        Assert.assertTrue(hp.validatePauseBtn());
    }

    @Test
    public void nextBannerTest(){
        HomePage hp = new HomePage();
        hp.nextBanner();

    }
    @Test
    public void previousBannerTest(){
        HomePage hp = new HomePage();
        hp.previousBanner();

    }
}
