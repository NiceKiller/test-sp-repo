package steps;

import enums.Restrictions;
import org.openqa.selenium.WebDriver;
import page.confluance.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by bzawa on 1/16/2017.
 */
public class PageSteps {

    private MenuBarPage menuBarPage;
    private ContentBodyEditPage contentBodyEditPage;
    private SaveBarPage saveBarPage;
    private ContentBodyPage contentBodyPage;
    private RestrictionsPage restrictionsPage;

    public PageSteps(WebDriver driver) {
        this.menuBarPage = new MenuBarPage(driver);
        this.contentBodyEditPage = new ContentBodyEditPage(driver);
        this.saveBarPage = new SaveBarPage(driver);
        this.contentBodyPage = new ContentBodyPage(driver);
        this.restrictionsPage = new RestrictionsPage(driver);
    }

    public void createNewPage(String title){
        menuBarPage.clickCreateButton();
        contentBodyEditPage.enterContentTitle(title);
        saveBarPage.savePage();
        assertThat(contentBodyPage.getContentTitleText()).isEqualTo(title).as("Check if page title is correct and page was created");
    }

    public void setRestrictions(Restrictions restrictions) {
        contentBodyPage.clickOnRestrictionsHeaderIcon();
        restrictionsPage.selectRestrictions(restrictions);
        restrictionsPage.saveRestrictions();
        assertThat(contentBodyPage.getRestrictionHeaderIconOriginalTitleAtributeText()).isEqualTo("Restrictions apply").as("Check if restriction was applied");
    }

}
