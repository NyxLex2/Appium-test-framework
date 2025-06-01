package co.obrio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='genesis.nebula:id/editView']")
    private WebElement emailInput;

    @AndroidFindBy(xpath = "//android.widget.EditText[@password='true']")
    private WebElement passwordInput;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Enter a valid email']")
    private WebElement emailError;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Incorrect password']")
    private WebElement passwordError;

    public LoginPage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    public void enterEmail(String email) {
        onPageSendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        onPageSendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        onPageClick(loginButton);
    }

    public boolean isEmailErrorDisplayed() {
        return isElementDisplayed(emailError);
    }

    public boolean isPasswordErrorDisplayed() {
        return isElementDisplayed(passwordError);
    }

    public String getEmailErrorText() {
        return getElementText(emailError);
    }

    public String getPasswordErrorText() {
        return getElementText(passwordError);
    }
}