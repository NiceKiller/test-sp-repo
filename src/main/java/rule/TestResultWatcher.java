package rule;

import helper.ScreenshotHelper;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Created by Bartlomiej_Zawadzki on 9/29/2016.
 */
public class TestResultWatcher extends TestWatcher {

    private WebDriver driver;
    private ScreenshotHelper screenshotHelper;

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    protected void failed(Throwable e, Description description) {
        screenshotHelper = new ScreenshotHelper();
        screenshotHelper.takeScreenShotOnFailure(description, driver);
    }

    @Override
    protected void finished(Description description) {
        if (this.driver != null) {
            try {
                this.driver.quit();
            } catch (WebDriverException e) {
                this.failed(e, description);
            }
        }

    }


}
