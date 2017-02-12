package common;

import driver.WebDriverProvider;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import rule.TestResultWatcher;


/**
 * Created by bzawa on 9/28/2016.
 */
public class AbstractBaseTest {

    @Rule
    public TestResultWatcher testResultWatcher;

    private final static String BaseURL = "";
    protected WebDriver driver;

    public AbstractBaseTest() {
        testResultWatcher = new TestResultWatcher();
    }

    @Before
    public void prepare() {
        driver = new WebDriverProvider().getDriver();
        testResultWatcher.setWebDriver(driver);
        driver.navigate().to(BaseURL);
    }

}
