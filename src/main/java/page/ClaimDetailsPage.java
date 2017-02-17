package page;

import elements.widget.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/16/2017.
 */
public class ClaimDetailsPage extends AbstractPage {

    public ClaimDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "mailsButton-btnIconEl")
    private Button mails;

    public MailsPage openMails(){
        mails.click();
        return new MailsPage(driver);
    }
}

