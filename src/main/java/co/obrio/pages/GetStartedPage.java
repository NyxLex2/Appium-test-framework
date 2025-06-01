package co.obrio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class GetStartedPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Already have an account? Log in']")
    private WebElement loginButton;

    public GetStartedPage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
    }

    public NebulaMemberPage clickLogin() {
        onPageClick(loginButton);
        return new NebulaMemberPage();
    }
}