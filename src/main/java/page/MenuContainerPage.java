package page;

import elements.widget.Label;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by bzawa on 2/14/2017.
 */

public class MenuContainerPage extends AbstractPage {

    public MenuContainerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'logged-as')]")
    private Label loggedAs;

    public String getLoginFromLoggedAs(){
        String loggedAsText = loggedAs.getText();
        return loggedAsText.substring(loggedAsText.indexOf("(")+1, loggedAsText.indexOf(")"));
    }
}
