package co.obrio.pages.profile;

import co.obrio.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BirthDatePage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.NumberPicker[1]")
    private WebElement monthPicker;

    @AndroidFindBy(xpath = "//android.widget.NumberPicker[2]")
    private WebElement dayPicker;

    @AndroidFindBy(xpath = "//android.widget.NumberPicker[3]")
    private WebElement yearPicker;

    @AndroidFindBy(id = "genesis.nebula:id/primaryButton")
    private WebElement saveButton;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement cancelButton;

    public BirthDatePage() {
        super();
    }

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(monthPicker));
        wait.until(ExpectedConditions.visibilityOf(dayPicker));
        wait.until(ExpectedConditions.visibilityOf(yearPicker));
    }

    public void selectMonth(String month) {
        selectField(monthPicker, month);
    }

    public void selectDay(String day) {
        selectField(dayPicker, day);
    }

    public void selectYear(String year) {
        selectField(yearPicker, year);
    }

    public void clickSave() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        onPageClick(saveButton);
    }

    public void clickCancel() {
        onPageClick(cancelButton);
    }

    private void selectField(WebElement picker, String value) {
        WebElement field = picker.findElement(By.xpath(".//android.widget.EditText"));
        wait.until(ExpectedConditions.elementToBeClickable(field));
        field.click();
        field.clear();
        field.sendKeys(value);
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

}