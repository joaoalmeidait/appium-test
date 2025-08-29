package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage {

    protected AndroidDriver driver;
    private final Duration TIMEOUT_DURATION = Duration.ofSeconds(20);

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElement(By locator) {
        return new WebDriverWait(driver, TIMEOUT_DURATION)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}