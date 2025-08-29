package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class DriverManager {

    private static AndroidDriver driver;

    public static void setUp(String appPackage, String appWaitActivity) throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage(appPackage)
                .setAppWaitActivity(appWaitActivity)
                .setUdid("emulator-5554")
                .setEnsureWebviewsHavePages(true)
                .setNativeWebScreenshot(true)
                .setNewCommandTimeout(Duration.ofSeconds(3600));

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}