package helper;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static com.google.common.io.Files.toByteArray;

/**
 * Created by Bartlomiej_Zawadzki on 9/30/2016.
 */
public class ScreenshotHelper {

    Logger logger = LoggerFactory.getLogger(ScreenshotHelper.class);

    public byte[] takeScreenShot(Scenario scenario, WebDriver driver) {
        File screenshoot = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = getScreenShotFilePath(scenario);
        try {
            FileUtils.copyFile(scrFile, screenshoot = new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Creating screenshot: " + screenshotPath);
        return screenshotToByte(screenshoot);
    }

    @Attachment(value = "{0}", type = "image/png")
    private byte[] screenshotToByte(File screenshot) {
        try {
            return toByteArray(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private String getScreenShotFilePath(Scenario scenario) {
        return "target\\screenshot\\" + scenario.getName() + new Date().getTime() + ".jpg";
    }
}
