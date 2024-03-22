package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.SetupTests;

public class MainPageTests extends SetupTests {

    private MainPage mainPage;


    @BeforeTest
    public void setup(){
        mainPage = openMainPage();
    }

    @Test
    public void isMainPageOpened(){
        mainPage.isMainUrlCorrect();
    }

    @Test
    public void openSubmenu(){
        mainPage.accountClick()
                .countSubmenuOptions()
                .isSubmenuOpened();
    }


}
