package co.obrio.business;

import co.obrio.pages.AdPage;

public class AdBO {
    private final AdPage adPage;

    public AdBO() {
        this.adPage = new AdPage();
    }

    public void closeAds() {
        adPage.closeFirstAd();
        adPage.closeSecondAd();
    }
}