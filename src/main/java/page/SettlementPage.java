package page;

import elements.widget.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/14/2017.
 */
public class SettlementPage extends AbstractPage {

    public SettlementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addByHandBtn-btnIconEl")
    private Button addManually;

    @FindBy(id = "finishCaseBtn-btnInnerEl")
    private Button completeClaim;

    public AddSettlementItemPage addManually() {
        customWaits.waitForElementPresent(addManually);
        addManually.click();
        return new AddSettlementItemPage(driver);
    }

    public CreateCustomerPage completeClaim(){
        completeClaim.click();
        return new CreateCustomerPage(driver);
    }
}
