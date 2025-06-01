package co.obrio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class SettingsPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
    private WebElement myProfileButton;

    public SettingsPage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(myProfileButton));
    }

    public UpdateProfileModal clickMyProfile() {
        onPageClick(myProfileButton);
        return new UpdateProfileModal();
    }
}