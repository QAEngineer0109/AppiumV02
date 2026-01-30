package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductsPage;

public class CompletePurchaseTest extends BaseTest {

    @Test
    public void CompletePurchaseTest() {

        String name = "Brett";
        String product = "Jordan 6 Rings";

        ProductsPage productsPage = new HomePage()
                .enterName(name)
                .tapLetsShop();

        productsPage.addProductToCartByName(product);

        CartPage cartPage = productsPage.goToCart();

        CheckoutPage checkoutPage = cartPage
                .checkTermsCheckbox()
                .tapProceed()
                .hideKeyboardIfVisible();

        Assert.assertTrue(checkoutPage.isSessionAlive(),
                "Driver session was lost after tapping Proceed");
    }
}

