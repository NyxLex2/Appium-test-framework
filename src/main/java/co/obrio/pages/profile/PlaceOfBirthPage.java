package co.obrio.pages.profile;

import co.obrio.pages.BasePage;

public class PlaceOfBirthPage extends BasePage {
    private final CitySelectorPage citySelectorPage = new CitySelectorPage();

    @Override
    protected void waitForPageToLoad() {
        citySelectorPage.waitForPageToLoad();
    }

    public void enterCity(String city) {
        citySelectorPage.enterCity(city);
    }

    public void selectCityFromList(String cityUkr) {
        citySelectorPage.selectCityFromList(cityUkr);
    }

}