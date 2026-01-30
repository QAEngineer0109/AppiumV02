package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

public class CartPage extends BasePage {

    private final By cartProductNames = By.id("com.androidsample.generalstore:id/productName");

    // Terms & Conditions
    private final By termsButton = By.id("com.androidsample.generalstore:id/termsButton");
    private final By alertTitle = By.id("com.androidsample.generalstore:id/alertTitle");

    // Checkout controls on Cart screen
    private final By checkBox = By.className("android.widget.CheckBox");
    private final By proceedButton = By.id("com.androidsample.generalstore:id/btnProceed");

    public boolean isProductInCart(String productName) {
        List<WebElement> products = driver.findElements(cartProductNames);

        for (WebElement product : products) {
            String text = product.getText();
            if (text != null && text.equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public CartPage longPressTermsButton() {
        WebElement ele = driver.findElement(termsButton);

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) ele).getId(),
                "duration", 2000
        ));

        return this;
    }

    public String getTermsAlertTitle() {
        return getText(alertTitle);
    }

    public CartPage checkTermsCheckbox() {
        click(checkBox);
        return this;
    }

    public CheckoutPage tapProceed() {
        click(proceedButton);
        return new CheckoutPage();
    }

	
	}

