package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactsPage extends BasePage {

    public ContactsPage(AndroidDriver driver) {
        super(driver);
    }

    public void openContacts(){
        WebElement contactsIcon = waitForElement(By.xpath("(//android.widget.LinearLayout[@resource-id=\"com.google.android.contacts:id/navigation_bar_item_content_container\"])[1]"));
        contactsIcon.click();
    }

    public void clickAddContactsButton(){
        WebElement addContactButton = waitForElement(By.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create contact\"]"));
        addContactButton.click();
    }

    public void enterContactInfo(String name, String phone){
        WebElement nameField = waitForElement(By.xpath("//android.widget.EditText[@text=\"First name\"]"));
        nameField.sendKeys(name);
        WebElement phoneField = waitForElement(By.xpath("//android.widget.EditText[@text=\"Phone\"]"));
        phoneField.sendKeys(phone);
    }

    public void saveContact(){
        WebElement saveButton = waitForElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button"));
        saveButton.click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }


    public void findContact(String name) {
        WebElement searchButton = waitForElement(By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.contacts:id/open_search_bar\"]"));
        searchButton.click();
        searchButton.sendKeys(name);
        WebElement contactResult = waitForElement(By.xpath("//android.widget.TextView[@text=\"" + name + "\"]"));
        contactResult.click();
    }
}
