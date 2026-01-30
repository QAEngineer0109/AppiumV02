package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductsPage;

public class LetsShopTest extends BaseTest {

    @Test
    public void LetsShopTest() {

        ProductsPage productsPage = new HomePage()
                .enterName("Brett")
                .tapLetsShop();

        String products = productsPage.getTitle();
        System.out.println(products);
        Assert.assertEquals(products, "Products");
    }
}

