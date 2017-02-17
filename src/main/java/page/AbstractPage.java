package page;

import elements.factory.api.ElementFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wait.CustomWaits;



/**
 * Created by bzawa on 9/28/2016.
 */
public abstract class AbstractPage {

    Logger logger = LoggerFactory.getLogger(AbstractPage.class);

    protected CustomWaits customWaits;
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        customWaits = new CustomWaits(driver);
        initPage();
    }

    private void initPage() {
        ElementFactory.initElements(driver, this);
    }

    /**
     * @param numberOfWindowsToWait number of open windows that method will be waiting for.
     * @param indexOfWindowToSwitch index of window yu want to switch to.
     */
    protected void waitAndSwitchToWindow(int numberOfWindowsToWait, int indexOfWindowToSwitch) {
        customWaits.waitForNumberOfWindowsToEqual(numberOfWindowsToWait);
        String winHandle = driver.getWindowHandles().toArray()[indexOfWindowToSwitch].toString();
        logger.info("Switching to window id: " + winHandle);
        driver.switchTo().window(winHandle);
    }

}
