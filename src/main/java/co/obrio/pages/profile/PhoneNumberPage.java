package co.obrio.pages.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import co.obrio.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PhoneNumberPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement phoneNumberInput;

    @AndroidFindBy(id = "genesis.nebula:id/consentCheckbox")
    private WebElement consentCheckbox;

    @AndroidFindBy(id = "genesis.nebula:id/submitButton")
    private WebElement saveButton;

    @Override
    public void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput));
        wait.until(ExpectedConditions.visibilityOf(saveButton));
    }

    public void enterPhoneNumber(String phone) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberInput));
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phone);
    }

    public void checkConsentCheckbox() {
        if (!consentCheckbox.isSelected()) {
            consentCheckbox.click();
        }
    }

    public void savePhoneNumber() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        onPageClick(saveButton);
    }
}