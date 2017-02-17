package page;

import elements.widget.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by bzawa on 2/14/2017.
 */

public class MyPagePage extends AbstractPage {

    Logger logger = LoggerFactory.getLogger(MyPagePage.class);
    private MenuContainerPage menuContainerPage;

    public MyPagePage(WebDriver driver) {
        super(driver);
        menuContainerPage = new MenuContainerPage(driver);
    }

    @FindBy(id="CreateNewClaim")
    private Button createNewCase;

    @FindBy(xpath = "//td[contains(@id, 'RecentClaimNumber')]")
    private List<WebElement> claimsNumbers;

    public MenuContainerPage getMenuContainerPage() {
        return menuContainerPage;
    }

    public NewCustomerPage createNewCase(){
        customWaits.waitForElementBeingClickable(createNewCase);
        createNewCase.click();
        return new NewCustomerPage(driver);
    }

    public boolean isClaimNumberOnList(String claimNumber){
        return claimsNumbers.stream().anyMatch((element) -> element.getText().equals(claimNumber));
    }

    public ClaimDetailsPage openClaim(String claimNumber){
        WebElement claim = claimsNumbers.stream()
                .filter((element) -> element.getText().equals(claimNumber))
                .findAny().orElse(null);
        logger.info("Found claim number: " + claim.getText());
        claim.findElement(By.xpath(".//..//a[contains(@id, 'RecentCustomer')]")).click();
        return new ClaimDetailsPage(driver);
    }
}
