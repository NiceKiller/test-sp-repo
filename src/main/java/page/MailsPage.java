package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by bzawa on 2/16/2017.
 */

public class MailsPage extends AbstractPage{

    public MailsPage(WebDriver driver) {
        super(driver);
    }

    private final By loadMask = By.xpath("//div[contains(@id, 'loadmask') and contains(@aria-hidden, 'true')]");

    //TODO: emails are not displayed
    public boolean isEmailSent(){
        customWaits.waitForInvisibilityOfElement(loadMask);
        return false;
    }

}
