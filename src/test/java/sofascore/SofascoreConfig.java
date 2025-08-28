package sofascore;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class SofascoreConfig {
    private static AndroidDriver driver;

    public void setUp() throws URISyntaxException, MalformedURLException {
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

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void clickGetStarted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement startButton = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"GET STARTED\"]")));
        startButton.click();
    }

    public void searchForTeam(String team) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.sofascore.results:id/search_edit\"]")));
        searchBox.click();
        searchBox.sendKeys(team);

        WebElement teamName = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.sofascore.results:id/name\"])[1]")));
        if (teamName.getText().equals(team)) {
            teamName.click();
            WebElement continueButton = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUE\"]"));
            continueButton.click();

            WebElement remindLater = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"REMIND ME LATER\"]"));
            remindLater.click();
        } else {
            System.out.println("Time não encontrado");
            throw new AssertionError("Time não encontrado: " + team);
        }

    }

    public void verifyFavorite(String team) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement favoritesTab = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.HorizontalScrollView[@resource-id=\"com.sofascore.results:id/bottom_tabs\"]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup")));
        favoritesTab.click();

        WebElement teamsTab = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text=\"Teams\"]")));
        teamsTab.click();

        WebElement teamFavoriteBanner = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.GridView[@resource-id=\"com.sofascore.results:id/recycler_view\"]/android.view.ViewGroup[1]")));

        if (teamFavoriteBanner.isDisplayed()) {
            System.out.println("Time encontrado");
        } else {
            throw new AssertionError("Time não encontrado como favorito: " + team);
        }
    }
}