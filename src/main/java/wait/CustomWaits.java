package wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bzawa on 9/27/2016.
 */
public class CustomWaits {

    private FluentWait<WebDriver> wait;
    private int globalWaitTime;

    public CustomWaits(WebDriver driver) {
        this.globalWaitTime = 15;
        wait = new WebDriverWait(driver, globalWaitTime)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
    }

    public WebElement waitForElementPresent(final WebElement element) {
        return waitForElementPresent(element, globalWaitTime);
    }

    private WebElement waitForElementPresent(final WebElement element, final int seconds) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementBeingClickable(final WebElement element) {
        return waitForElementBeingClickable(element, globalWaitTime);
    }

    private WebElement waitForElementBeingClickable(final WebElement element, final int seconds) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForElementIsNotVisible(final By locator) {
        return waitForElementIsNotVisible(locator, globalWaitTime);
    }

    private Boolean waitForElementIsNotVisible(final By locator, final int seconds) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
