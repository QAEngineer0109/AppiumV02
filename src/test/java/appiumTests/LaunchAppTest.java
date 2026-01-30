package appiumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class LaunchAppTest extends BaseTest {

    @Test
    public void LaunchAppTest() {
        HomePage home = new HomePage();
        String homePage = home.getYourNameLabelText();
        System.out.println(homePage);
        Assert.assertEquals(homePage, "Your Name");
    }
}
