package driver;

import org.openqa.selenium.WebDriver;

/**
 * Created by bzawa on 9/28/2016.
 */
public class WebDriverProvider {

    private final WebDriver driver;

    public WebDriverProvider() {
        this(WebDriverCreators.DEFAULT);
    }

    public WebDriverProvider(WebDriverCreator creator) {
        driver = creator.create();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
