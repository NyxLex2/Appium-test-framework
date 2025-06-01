package co.obrio.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import co.obrio.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.AssertUtils;

public class ProfilePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Date of birth']")
    private WebElement birthDateField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='genesis.nebula:id/headerTitle']")
    private WebElement profileTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='genesis.nebula:id/summaryValue']")
    private WebElement birthDateValue;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Relationship status']")
    private WebElement relationshipStatusField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='genesis.nebula:id/summaryValue' and preceding-sibling::android.widget.TextView[@text='Relationship status']]")
    private WebElement relationshipStatusValue;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    private WebElement okButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Phone number']")
    private WebElement phoneNumberField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Place of birth']")
    private WebElement placeOfBirthField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='genesis.nebula:id/summaryValue' and preceding-sibling::android.widget.TextView[@text='Place of birth']]")
    private WebElement placeOfBirthValue;

    public ProfilePage() {
        super();
    }

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(profileTitle));
        wait.until(ExpectedConditions.visibilityOf(birthDateField));
    }

    public BirthDatePage clickBirthDate() {
        onPageClick(birthDateField);
        return new BirthDatePage();
    }

    public void openRelationshipStatusSelector() {
        onPageClick(relationshipStatusField);
    }

    public void selectRelationshipStatusByDisplayName(String displayName) {
        WebElement option = driver.findElement(By.xpath("//android.widget.TextView[@text='" + displayName + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(option));
        option.click();
    }

    public String getRelationshipStatus() {
        return getElementText(relationshipStatusValue);
    }

    public String getBirthDate() {
        return getElementText(birthDateValue);
    }

    public PhoneNumberPage openPhoneNumberEditor() {
        onPageClick(phoneNumberField);
        return new PhoneNumberPage();
    }

    public void verifyPhoneNumberIsVisible(String expectedPhone) {
        WebElement phoneElement = driver
                .findElement(By.xpath("//android.widget.TextView[@text='" + "+380" + expectedPhone + "']"));
        AssertUtils.assertTrue(phoneElement.isDisplayed(), " phone number is not displayed");
    }

    public void clickPlaceOfBirth() {
        onPageClick(placeOfBirthField);
    }

    public void verifyPlaceOfBirthIsVisible(String expectedCityUkr) {
        wait.until(ExpectedConditions.visibilityOf(profileTitle));
        WebElement cityElement = driver
                .findElement(By.xpath("//android.widget.TextView[@text='" + expectedCityUkr + "']"));
        AssertUtils.assertTrue(cityElement.isDisplayed(), "Place of birth is not displayed correctly");
    }
}
