package mobile.login;

import mobile.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import co.obrio.business.LoginBO;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginBO loginBO = new LoginBO();
        var profilePage = loginBO.performLogin();

        Assert.assertTrue(profilePage.isProfilePageDisplayed(), "Profile page should be displayed after login");
    }
}