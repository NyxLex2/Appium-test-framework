package co.obrio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class NebulaMemberPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONTINUE WITH EMAIL']")
    private WebElement usingEmailButton;

    public NebulaMemberPage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(usingEmailButton));
    }

    public LoginPage clickUsingEmailButton() {
        waitAndClick(usingEmailButton);
        return new LoginPage();
    }
}