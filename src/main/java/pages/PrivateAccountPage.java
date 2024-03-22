package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class PrivateAccountPage extends BasePage{


    /**
     * Constructor for the PrivateAccountPage class.
     *
     * @param driver
     */
    public PrivateAccountPage(WebDriver driver){
        super(driver);
    }

    private JavascriptExecutor js = (JavascriptExecutor) driver;


    @FindBy(css="#main > section.infobox-grid.lifting.viewed > div > div > div:nth-child(2) > div > a")
    private WebElement secondAccountOffer;

    @FindBy(xpath = "//div[@class='headline']/h1[contains(text(), 'osobiste')]")
    private WebElement privateAccountText;

    @FindBy(xpath = "//h2[contains(text(), 'Jak założyć')]")
    private WebElement headerText;

    @FindBy(xpath = "//*[@aria-label = 'eKonto dla młodych']")
    private WebElement youthAccount;

    @FindBy(css = "//*[@id='app']/div/div/div[2]/div/div[2]/button[3]/text()")
    private WebElement cookiesBtn;


    /**
     * Verifies if the current URL of the page is the correct URL for private accounts in the mBank service.
     */
    public void isPrivateAccountUrlCorrect(){
        String actualPrivateAccountUrl = driver.getCurrentUrl();
        assertEquals("https://www.mbank.pl/indywidualny/konta/konta-osobiste/", actualPrivateAccountUrl);
    }

    /**
     * Gets and prints the text content of the header element on the current page.
     *
     * @return PrivateAccountPage
     */
    public PrivateAccountPage headerText(){
        System.out.println(headerText.getText());
        return this;
    }

    /**
     * Verifies if the header text on the private account page is correct.
     */
    public void isHeaderTextCorrect(){
        assertEquals("Jak założyć konto w banku przez Internet?", headerText.getText());
    }

    /**
     * Goes to the youth account page.
     *
     * @return YouthAccountPage
     */
    public YouthAccountPage youthAccountClick(){
        youthAccount.click();
        return new YouthAccountPage(driver);
    }
}
