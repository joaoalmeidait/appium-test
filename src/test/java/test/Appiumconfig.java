package test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Appiumconfig {

    private final AndroidDriver driver;
    private final String apk = "/Users/joaoalmeida/AndroidStudioProjects/MyApplication4/app/build/outputs/apk/debug/hello-app.apk";

    public Appiumconfig() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setApp(apk)
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2");

        driver = new AndroidDriver(
                new URI("http://127.0.0.1:4723").toURL(), options
        );
    }

    public void runTest() {
        try {
//            Thread.sleep(5000);
            WebElement myButton = driver.findElement(AppiumBy.id("com.example.myapplication:id/myButton"));
            myButton.click();
            System.out.println("Botão clicado com sucesso!");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}