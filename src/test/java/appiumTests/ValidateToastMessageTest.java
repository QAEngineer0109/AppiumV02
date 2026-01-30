package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class ValidateToastMessageTest extends BaseTest {

    @Test
    public void ValidateToastMessageTest() {

        String toastMessage = new HomePage()
                .tapLetsShopAndGetToastMessage();

        System.out.println(toastMessage);
        Assert.assertEquals(toastMessage, "Please enter your name");
    }
}
