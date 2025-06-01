package co.obrio.pages;

import co.obrio.pages.BasePage;
import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class AdPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='genesis.nebula:id/premiumCloseButton']")
    private WebElement closeFirstAdButton;//resource-id="genesis.nebula:id/closeIb"

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='genesis.nebula:id/closeIb']")
    private WebElement closeSecondAAdButton;

    public AdPage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(webDriver -> closeFirstAdButton.isDisplayed());
    }

    public void closeFirstAd() {
        onPageClick(closeFirstAdButton);
    }

    public void closeSecondAd() {
        onPageClick(closeSecondAAdButton);
    }
}