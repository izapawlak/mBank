package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MainPage extends BasePage{
    /**
     * Constructor for the MainPage class.
     *
     * @param driver
     */
    public MainPage(final WebDriver driver) {
        super(driver);
    }
    private JavascriptExecutor js = (JavascriptExecutor) driver;


    @FindBy(css=".submenu-item-href.nmp")
    private WebElement accountBtn;

    @FindBy(css="#subsubmenu-item-1 > div > a")
    private WebElement privateAccounts;

    @FindBy(css="#submenu-item-1 > ul")
    private WebElement submenu;

    @FindBy(xpath="(//ul[@class='submenu offer'])[1]/li[contains(@id, 'subsubmenu-item-')]/div[@role='none']/a")
    private List<WebElement> submenuOptions;

/*    @FindBy(css = "li#submenu-item-2 > ul.submenu.offer")
    private WebElement submenuOpened;*/


    /**
     *  * Verifies if the current page URL matches the expected URL ("https://skleptest.pl/").
     */
    public void isMainUrlCorrect() {
        driver.getCurrentUrl();
        assertEquals("https://www.mbank.pl/indywidualny/", driver.getCurrentUrl());
    }

    /**
     * Clicks account button.
     *
     * @return MainPage
     */
    public MainPage accountClick(){
        accountBtn.click();
        return this;
    }

    /**
     * Verifies if the submenu is currently opened and displayed on the page.
     */
    public void isSubmenuOpened(){
        assertTrue(submenu.isDisplayed());
    }

    /**
     * Counts the visible options within accounts submenu and prints the count to the console.
     *
     * @return MainPage
     */
    public MainPage countSubmenuOptions(){
        accountBtn.click();
        int numberOfElements = submenuOptions.size();
        System.out.println("Liczba elementow: " + numberOfElements);
        return this;
    }

    /**
     * Opens Private Account Page.
     *
     * @return PrivateAccountPage
     */
    public PrivateAccountPage privateAccountsClick(){
        js.executeScript("arguments[0].click();", privateAccounts);
        return new PrivateAccountPage(driver);
    }
}
