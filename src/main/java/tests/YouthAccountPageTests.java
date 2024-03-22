package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.PrivateAccountPage;
import utils.SetupTests;

public class YouthAccountPageTests extends SetupTests {

    private MainPage mainPage;
    private PrivateAccountPage privateAccountPage;

    @BeforeTest
    public void setup(){
        mainPage = openMainPage();
    }

    @Test
    public void goToYouthAccountPage(){
        privateAccountPage.youthAccountClick()
                .isYouthHeaderTextCorrect();
    }
}
