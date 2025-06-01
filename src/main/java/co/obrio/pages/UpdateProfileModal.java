package co.obrio.pages;

import co.obrio.pages.profile.ProfilePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class UpdateProfileModal extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='OK']")
    private WebElement okButton;

    public UpdateProfileModal() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(okButton));
    }

    public ProfilePage clickOk() {
        onPageClick(okButton);
        return new ProfilePage();
    }
}