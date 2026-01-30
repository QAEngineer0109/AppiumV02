package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;

public class ProductsPage extends BasePage {

    private final By toolbarTitle = By.id("com.androidsample.generalstore:id/toolbar_title");

    // Product list locators
    private final By productNames = By.id("com.androidsample.generalstore:id/productName");
    private final By addToCartButtons = By.id("com.androidsample.generalstore:id/productAddCart");

    // Cart icon
    private final By cartButton = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    public String getTitle() {
        return getText(toolbarTitle);
    }

    /**
     * Scrolls the products list until the given product name is found,
     * then taps its corresponding "Add to Cart" button.
     */
    public ProductsPage addProductToCartByName(String productNameToAdd) {

        boolean added = false;
        int maxScrolls = 15; // prevents infinite loops

        for (int scroll = 0; scroll < maxScrolls && !added; scroll++) {

            List<WebElement> names = driver.findElements(productNames);
            List<WebElement> buttons = driver.findElements(addToCartButtons);

            int count = Math.min(names.size(), buttons.size());

            for (int i = 0; i < count; i++) {
                String nameText = names.get(i).getText();
                if (nameText != null && nameText.equalsIgnoreCase(productNameToAdd)) {
                    buttons.get(i).click();
                    added = true;
                    break;
                }
            }

            if (!added) {
                // Scroll forward to reveal more products
                driver.findElement(AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
                ));
            }
        }

        if (!added) {
            throw new RuntimeException("Product not found to add: " + productNameToAdd);
        }

        return this;
    }

    public CartPage goToCart() {
        click(cartButton);
        return new CartPage();
    }
}

