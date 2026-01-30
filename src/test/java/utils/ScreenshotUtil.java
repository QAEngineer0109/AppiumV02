package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.android.AndroidDriver;

public class ScreenshotUtil {

    public static String takeScreenshot(AndroidDriver driver, String testName) throws Exception {
        if (driver == null) throw new IllegalStateException("Driver is null, cannot take screenshot.");

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dir = System.getProperty("user.dir") + File.separator + "test-output" + File.separator + "screenshots";
        new File(dir).mkdirs();

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(dir + File.separator + testName + "_" + timeStamp + ".png");

        Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return dest.getAbsolutePath();
    }
}
