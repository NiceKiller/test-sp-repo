package helper;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static com.google.common.io.Files.toByteArray;
import static utils.TestDescription.getSimpleMethodName;

/**
 * Created by Bartlomiej_Zawadzki on 9/30/2016.
 */
public class ScreenshotHelper {

    public byte[] takeScreenShotOnFailure(Description description, WebDriver driver) {
        File screenshoot = null;
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, screenshoot = new File(getScreenShotFilePath(description)));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private String getScreenShotFilePath(Description description) {
        return "target\\screenshot\\" + getScreenShotName(description) + ".jpg";
    }

    private String getScreenShotName(Description description) {
        return getSimpleMethodName(description) + "_" + new Date().getTime();
    }
}
