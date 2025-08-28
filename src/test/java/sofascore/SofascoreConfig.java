package sofascore;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class SofascoreConfig {

    private final AndroidDriver driver;

    public SofascoreConfig() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.sofascore.results")
                .setAppWaitActivity("com.sofascore.results.onboarding.OnboardingActivity")
                .setUdid("emulator-5554")
                .setEnsureWebviewsHavePages(true)
                .setNativeWebScreenshot(true)
                .setNewCommandTimeout(Duration.ofSeconds(3600));

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
    }

    public void runTest() {
        try {
//            Thread.sleep(5000);
            WebElement myButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome to Sofascore\"]"));
            myButton.isDisplayed();
            System.out.println("Sofascore aberto!");

            WebElement startButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"GET STARTED\"]"));
            startButton.click();

            WebElement searchBox = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.sofascore.results:id/search_edit\"]"));
            searchBox.click();
            searchBox.sendKeys("Flamengo");

            WebElement team = driver.findElement(AppiumBy.xpath("//android.widget.GridView[@resource-id=\"com.sofascore.results:id/search_recycler_view\"]/android.view.ViewGroup[1]"));
            WebElement teamName = team.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.sofascore.results:id/name\"])[1]"));

            if (teamName.getText().equals("Flamengo")) {
                System.out.println("Time encontrado");
                team.click();
            } else {
                System.out.println("Time nao encontrado");
            }

            WebElement continueButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUE\"]"));
            continueButton.click();

            WebElement remindLater = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"REMIND ME LATER\"]"));
            remindLater.click();

            WebElement favorites = driver.findElement(AppiumBy.xpath("//android.widget.HorizontalScrollView[@resource-id=\"com.sofascore.results:id/bottom_tabs\"]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup"));
            favorites.click();

            WebElement teamClick = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Teams\"]"));
            teamClick.click();

            WebElement teamFavoriteBanner = driver.findElement(AppiumBy.xpath("//android.widget.GridView[@resource-id=\"com.sofascore.results:id/recycler_view\"]/android.view.ViewGroup[1]"));
            teamFavoriteBanner.click();

            WebElement favoriteTeamName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.sofascore.results:id/primary_label\"]"));

            if (favoriteTeamName.getText().equals("Flamengo")) {
                System.out.println("Time encontrado");
            } else {
                System.out.println("Time nao encontrado");
            }

        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}