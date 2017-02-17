package wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bzawa on 9/27/2016.
 */
public class CustomWaits {

    Logger logger = LoggerFactory.getLogger(CustomWaits.class);

    private FluentWait<WebDriver> wait;
    private int globalWaitTime;

    public CustomWaits(WebDriver driver) {
        this.globalWaitTime = 20;
        wait = new WebDriverWait(driver, globalWaitTime)
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class);
    }

    public void waitForNumberOfWindowsToEqual(final int numberOfWindows) {
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                driver.getWindowHandles().forEach(logger::info);
                return (driver.getWindowHandles().size() == numberOfWindows);
            }
        });
    }

    public WebElement waitForElementPresent(final WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementBeingClickable(final WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForInvisibilityOfElement(final By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}
