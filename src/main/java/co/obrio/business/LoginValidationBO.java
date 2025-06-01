package co.obrio.business;

import co.obrio.pages.NebulaMemberPage;
import co.obrio.pages.GetStartedPage;
import co.obrio.pages.LoginPage;
import utils.AssertUtils;
import utils.RandomStringUtils;

public class LoginValidationBO {
    private final GetStartedPage getStartedPage;
    private final LoginPage loginPage;

    public LoginValidationBO() {
        this.getStartedPage = new GetStartedPage();
        this.loginPage = new LoginPage();
    }

    public void navigateToLoginPage() {
        getStartedPage.clickLogin();
        new NebulaMemberPage().clickUsingEmailButton();
    }

    public void validateInvalidEmailFormat() {
        navigateToLoginPage();
        loginPage.enterEmail(RandomStringUtils.generateRandomInvalidEmail());
        loginPage.enterPassword(RandomStringUtils.generateRandomPassword(8));
        loginPage.clickLoginButton();
    }

    public void validateShortPassword() {
        navigateToLoginPage();
        loginPage.enterEmail(RandomStringUtils.generateRandomEmail());
        loginPage.enterPassword(RandomStringUtils.generateRandomPassword(3));
        loginPage.clickLoginButton();
    }

    public boolean isEmailErrorDisplayed() {
        return loginPage.isEmailErrorDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return loginPage.isPasswordErrorDisplayed();
    }

    public String getEmailErrorText() {
        return loginPage.getEmailErrorText();
    }

    public String getPasswordErrorText() {
        return loginPage.getPasswordErrorText();
    }

    public void verifyEmailError(String expectedMessage) {
        AssertUtils.assertTrue(isEmailErrorDisplayed(), "Email error should be displayed");
        AssertUtils.assertEquals(getEmailErrorText(), expectedMessage, "Incorrect email error message");
    }

    public void verifyPasswordError(String expectedMessage) {
        AssertUtils.assertTrue(isPasswordErrorDisplayed(), "Password error should be displayed");
        AssertUtils.assertEquals(getPasswordErrorText(), expectedMessage, "Incorrect password error message");
    }
}