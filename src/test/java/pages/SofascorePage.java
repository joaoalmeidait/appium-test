package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.List;

public class SofascorePage {

    private final AndroidDriver driver;
    private final Duration TIMEOUT_DURATION = Duration.ofSeconds(20);

    public SofascorePage(AndroidDriver driver) {
        this.driver = driver;
    }

    private WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, TIMEOUT_DURATION)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickGetStarted() {
        WebElement startButton = waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"GET STARTED\"]"));
        startButton.click();
    }

    public void searchForTeam(String team) {
        WebElement searchBox = waitForElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.sofascore.results:id/search_edit\"]"));
        searchBox.click();
        searchBox.sendKeys(team);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void selectFirstTeamFromResults(String team) {
        WebElement teamName = waitForElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id=\"com.sofascore.results:id/name\"])[1]"));
        if (teamName.getText().equals(team)) {
            teamName.click();
        } else {
            throw new AssertionError("Time não encontrado: " + team);
        }
    }

    public void handleOnboardingPopups() {
        WebElement continueButton = waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"CONTINUE\"]"));
        continueButton.click();
        WebElement remindLater = waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"REMIND ME LATER\"]"));
        remindLater.click();
        List<WebElement> popUp = driver.findElements(By.xpath("//android.widget.ImageView[@resource-id=\"com.sofascore.results:id/image_view\"]"));
        if (!popUp.isEmpty()) {
            System.out.println("Pop-up de onboarding exibido.");
            WebElement closeButton = waitForElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.sofascore.results:id/collapse_button\"]"));
            closeButton.click();
        } else {
            System.out.println("Pop-up de onboarding não exibido.");
        }
    }

    public void navigateToFavoritesTab() {
        WebElement favoritesTab = waitForElement(AppiumBy.xpath("//android.widget.HorizontalScrollView[@resource-id=\"com.sofascore.results:id/bottom_tabs\"]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup"));
        favoritesTab.click();
    }

    public void verifyFavorite(String team) {
        WebElement teamsTab = waitForElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Teams\"]"));
        teamsTab.click();

        WebElement teamFavoriteBanner = waitForElement(AppiumBy.xpath("//android.widget.GridView[@resource-id=\"com.sofascore.results:id/recycler_view\"]/android.view.ViewGroup[1]"));

        if (teamFavoriteBanner.isDisplayed()) {
            System.out.println("Time favorito encontrado: " + team);
        } else {
            throw new AssertionError("Time não encontrado como favorito: " + team);
        }
    }
}