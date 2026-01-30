package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void AddToCartTest() {

        String product = "Jordan 6 Rings";

        ProductsPage productsPage = new HomePage()
                .enterName("Brett")
                .tapLetsShop();

        productsPage.addProductToCartByName(product);

        CartPage cartPage = productsPage.goToCart();

        Assert.assertTrue(cartPage.isProductInCart(product),
                product + " is NOT in the cart!");
    }

	
}

