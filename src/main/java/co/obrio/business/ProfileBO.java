package co.obrio.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import co.obrio.model.RelationshipStatus;
import co.obrio.pages.HomePage;
import co.obrio.pages.profile.BirthDatePage;
import co.obrio.pages.profile.PhoneNumberPage;
import co.obrio.pages.profile.PlaceOfBirthPage;
import co.obrio.pages.profile.ProfilePage;
import utils.AssertUtils;
import utils.RandomStringUtils;

public class ProfileBO {
    private ProfilePage profilePage;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 65;
    private static final int CURRENT_YEAR = LocalDate.now().getYear();
    private static final int DEFAULT_MONTH = 1;
    private static final int DEFAULT_DAY = 1;

    public ProfileBO() {
        this.profilePage = new ProfilePage();
    }

    public ProfilePage goToProfile(HomePage homePage) {
        new co.obrio.business.AdBO().closeAds();
        return homePage.clickSettings().clickMyProfile().clickOk();
    }

    public void updatePlaceOfBirth(String cityToInput, String cityToSelectUkr) {
        profilePage.clickPlaceOfBirth();
        PlaceOfBirthPage placeOfBirthPage = new PlaceOfBirthPage();
        placeOfBirthPage.enterCity(cityToInput);
        placeOfBirthPage.selectCityFromList(cityToSelectUkr);
    }

    public void verifyPlaceOfBirth(String expectedCityUkr) {
        profilePage.verifyPlaceOfBirthIsVisible(expectedCityUkr);
    }

    public String generateRandomBirthDate() {
        Random random = new Random();
        int randomAge = MIN_AGE + random.nextInt(MAX_AGE - MIN_AGE);
        int birthYear = CURRENT_YEAR - randomAge;

        LocalDate birthDate = LocalDate.of(birthYear, DEFAULT_MONTH, DEFAULT_DAY);
        return birthDate.format(DATE_FORMATTER);
    }

    public String getCurrentBirthDate() {
        refreshPage();
        profilePage.waitForPageToLoad();
        return profilePage.getBirthDate();
    }

    public void updateBirthDate(String newDate) {
        String[] dateParts = parseDate(newDate);
        BirthDatePage datePicker = profilePage.clickBirthDate();

        datePicker.selectMonth(dateParts[0]);
        datePicker.selectDay(dateParts[1]);
        datePicker.selectYear(dateParts[2]);
        datePicker.clickSave();

        refreshPage();
    }

    public void updateRelationshipStatus(RelationshipStatus status) {
        profilePage.openRelationshipStatusSelector();
        profilePage.selectRelationshipStatusByDisplayName(status.getDisplayName());
    }

    public void verifyRelationshipStatusUpdate(RelationshipStatus expectedStatus) {
        profilePage.waitForPageToLoad();
        String actualStatus = profilePage.getRelationshipStatus();
        AssertUtils.assertEquals(actualStatus, expectedStatus.getDisplayName(),
                "Relationship status was not updated correctly.");
    }

    public void verifyBirthDateUpdate(String initialDate, String expectedDate) {
        String updatedDate = getCurrentBirthDate();

        AssertUtils.assertTrue(!updatedDate.equals(initialDate),
                "Birth date was not changed. Initial and current date are the same: " + updatedDate);
        AssertUtils.assertEquals(updatedDate, expectedDate,
                String.format(
                        "Birth date was updated to an incorrect value. Expected: %s, but was: %s (initial was: %s)",
                        expectedDate, updatedDate, initialDate));
    }

    public String generateRandomPhoneNumber() {
        return RandomStringUtils.randomNumeric(9);
    }

    public void verifyPhoneNumberUpdate(String expectedPhone) {
        profilePage.waitForPageToLoad();
        profilePage.verifyPhoneNumberIsVisible(expectedPhone);
    }

    public void updatePhoneNumber(String phone) {
        PhoneNumberPage phoneNumberPage = profilePage.openPhoneNumberEditor();
        phoneNumberPage.enterPhoneNumber(phone);
        phoneNumberPage.checkConsentCheckbox();
        phoneNumberPage.savePhoneNumber();
    }

    private String[] parseDate(String date) {
        String[] parts = date.split(" ");
        return new String[] {
                parts[0],
                parts[1].replace(",", ""),
                parts[2]
        };
    }

    private void refreshPage() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        profilePage = new ProfilePage();
    }
}