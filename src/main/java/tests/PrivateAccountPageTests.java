package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.SetupTests;

public class PrivateAccountPageTests extends SetupTests {
    private MainPage mainPage;

    @BeforeTest
    public void setup(){
        mainPage = openMainPage();
    }

    @Test
    public void goToPrivateAccountPage(){
        mainPage.accountClick()
                .privateAccountsClick()
                .isPrivateAccountUrlCorrect();
    }

    @Test
    public void getHeaderText(){
        mainPage.accountClick()
                .privateAccountsClick()
                .headerText()
                .isHeaderTextCorrect();
    }

}
