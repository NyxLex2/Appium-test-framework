package co.obrio.pages.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import co.obrio.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CitySelectorPage extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement cityInput;

    @Override
    protected void waitForPageToLoad() {
        wait.until(ExpectedConditions.visibilityOf(cityInput));
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void selectCityFromList(String cityUkr) {
        WebElement cityOption = driver.findElement(By.xpath("//android.widget.TextView[@text='" + cityUkr + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(cityOption));
        cityOption.click();
    }
}