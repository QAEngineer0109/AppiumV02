package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class TermsAndConditionsTest extends BaseTest {

    @Test
    public void TermsAndConditionsTest() {

        String product = "Jordan 6 Rings";

        ProductsPage productsPage = new HomePage()
                .enterName("Brett")
                .tapLetsShop();

        productsPage.addProductToCartByName(product);

        CartPage cartPage = productsPage.goToCart();

        cartPage.longPressTermsButton();

        String title = cartPage.getTermsAlertTitle();
        System.out.println(title);

        Assert.assertEquals(title, "Terms Of Conditions");
    }
}
