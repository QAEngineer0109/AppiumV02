package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductsPage;

public class ShopSelectingUnitedStatesTest extends BaseTest {

    @Test
    public void ShopSelectingUnitedStatesTest() {

        ProductsPage productsPage = new HomePage()
                .selectCountry("India")   // change to "United States" when ready
                .enterName("Brett")
                .tapLetsShop();

        String products = productsPage.getTitle();
        System.out.println(products);
        Assert.assertEquals(products, "Products");
    }
}

