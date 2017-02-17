package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.OsCheck;

import java.util.concurrent.TimeUnit;

/**
 * Created by bzawa on 9/28/2016.
 */
public class WebDriverCreators {

    private WebDriverCreators() {
    }

    public static final WebDriverCreator CHROME = () -> {
        checkOsAndSetSystemProperty();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        ChromeDriver driver = new ChromeDriver(options);
        setDefaultSettings(driver);
        return driver;
    };

    public static final WebDriverCreator IE = () -> {
        if(checkOsAndSetSystemProperty()!= OsCheck.OSType.Windows){
            throw new IllegalStateException("IE driver will work only on windows");
        }
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

        ieCapabilities.setCapability("nativeEvents", false);
        ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
        ieCapabilities.setCapability("disable-popup-blocking", true);
        ieCapabilities.setCapability("enablePersistentHover", true);
        ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        InternetExplorerDriver driver = new InternetExplorerDriver(ieCapabilities);
        setDefaultSettings(driver);
        return driver;
    };

    public static final WebDriverCreator DEFAULT = IE;

    private static void setDefaultSettings(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
                .pageLoadTimeout(180, TimeUnit.SECONDS);
    }

    private static OsCheck.OSType checkOsAndSetSystemProperty() {
        OsCheck.OSType osType = OsCheck.getOperatingSystemType();
        switch (osType) {
            case Windows:
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver_win.exe");
                System.setProperty("webdriver.ie.driver", "src\\main\\resources\\drivers\\ie\\IEDriverServer.exe");
                break;
            case Linux:
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver_linux.exe");
                break;
            case MacOS:
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chrome\\chromedriver_mac.exe");
                break;
        }
        return osType;
    }

}
