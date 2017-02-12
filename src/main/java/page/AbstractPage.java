package page;

import elements.factory.api.ElementFactory;
import org.openqa.selenium.WebDriver;
import wait.CustomWaits;

import java.util.concurrent.TimeUnit;


/**
 * Created by bzawa on 9/28/2016.
 */
public abstract class AbstractPage {

    protected CustomWaits customWaits;
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        customWaits = new CustomWaits(driver);
        initPage();
    }

    private void initPage() {
        ElementFactory.initElements(driver, this);
    }

}
