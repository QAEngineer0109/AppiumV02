package base;

import java.net.URI;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Z5DQMVI7CAHMRODI");
        options.setApp("C:\\Users\\skipp\\General-Store.apk");

        AndroidDriver driver = new AndroidDriver(
                new URI("http://127.0.0.1:4723/").toURL(),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverFactory.setDriver(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        AndroidDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
        }
        DriverFactory.removeDriver();
    }
}

