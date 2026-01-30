package pages;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;

public class HomePage extends BasePage {

    // ====== LOCATORS ======

    // Label on launch screen
    private final By yourNameText =
            By.xpath("//android.widget.TextView[@text=\"Your Name\"]");

    // Name input
    private final By nameField =
            By.id("com.androidsample.generalstore:id/nameField");

    // Country dropdown
    private final By countryDropdown =
            By.id("com.androidsample.generalstore:id/spinnerCountry");

    // Let's Shop button
    private final By letsShopButton =
            By.id("com.androidsample.generalstore:id/btnLetsShop");

    // Toast message
    private final By toastMessage =
            By.xpath("(//android.widget.Toast)[1]");

    // ====== ACTIONS ======

    // Used by LaunchAppTest
    public String getYourNameLabelText() {
        return getText(yourNameText);
    }

    // Used by LetsShopTest & others
    public HomePage enterName(String name) {
        find(nameField).sendKeys(name);
        return this;
    }

    // Used by ShopSelectingUnitedStatesTest
    public HomePage selectCountry(String countryName) {
        click(countryDropdown);

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollTextIntoView(\"" + countryName + "\")"
        ));

        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + countryName + "\")"
        )).click();

        return this;
    }

    // Normal navigation to Products page
    public ProductsPage tapLetsShop() {
        click(letsShopButton);
        return new ProductsPage();
    }

    // Used by ValidateToastMessageTest
    public String tapLetsShopAndGetToastMessage() {
        click(letsShopButton);
        return driver.findElement(toastMessage).getAttribute("name");
    }
}
