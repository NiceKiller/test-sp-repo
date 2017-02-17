package page;

import elements.widget.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/16/2017.
 */
public class ConfirmCustomerInformationPage extends AbstractPage {

    public ConfirmCustomerInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sendmail")
    private Button sendMail;

    public MyPagePage confirmSendMail(){
        sendMail.click();
        return new MyPagePage(driver);
    }
}
