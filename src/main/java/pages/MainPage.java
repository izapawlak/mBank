package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath="(//div[@role = 'none'])[2]//following::ul[1]")
    private WebElement submenu;

    @FindBy(xpath="(//ul[@class='submenu offer'])[1]/li[contains(@id, 'subsubmenu-item-')]/div[@role='none']/a")
    private List<WebElement> submenuOptions;

    @FindBy(xpath = "(//span[@class = 'ui-slider-handle ui-corner-all ui-state-default'])[1]")
    private WebElement creditAmountSlider;

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
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //wait.until(ExpectedConditions.visibilityOf(submenu));
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
     * Verifies that the submenu has exactly 5 options available.
     */
    public void submnuOptionsNumber(){
        assertEquals(5, submenuOptions.size());
    }

    /**
     * Slides the credit amount slider to the right.
     *
     * @return MainPage
     */
    public MainPage slideCreditAmountSlider(){
        Point sliderStartLocation1 = creditAmountSlider.getLocation();
        System.out.println(sliderStartLocation1);
        Actions actions = new Actions(driver);
        actions.clickAndHold(creditAmountSlider).moveByOffset(100, 0).release().perform();
        Point sliderStartLocation2 = creditAmountSlider.getLocation();
        System.out.println(sliderStartLocation2);
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
