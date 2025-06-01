package co.obrio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='genesis.nebula:id/toolbar_settings']")
    private WebElement settingsButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='genesis.nebula:id/headerSubtitle']")
    private WebElement profileSubtitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='genesis.nebula:id/headerTitle']")
    private WebElement profileTitle;

    public HomePage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(settingsButton));
        wait.until(ExpectedConditions.visibilityOf(profileTitle));
    }

    public SettingsPage clickSettings() {
        onPageClick(settingsButton);
        return new SettingsPage();
    }

    public boolean isProfilePageDisplayed() {
        return isElementDisplayed(profileTitle) && isElementDisplayed(profileSubtitle);
    }

    public String getProfileSubtitle() {
        return getElementText(profileSubtitle);
    }
}