package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class YouthAccountPage extends BasePage{
    /**
     * Constructor for the YouthAccountPage class.
     *
     * @param driver
     */
    public YouthAccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(text(), 'Konta dla młodych')]")
    private WebElement youthHeader;

    public void isYouthHeaderTextCorrect(){
        assertEquals("Konta dla młodych w mBanku", youthHeader.getText());
    }



}
