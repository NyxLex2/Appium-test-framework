package mobile.profile;

import org.testng.annotations.Test;

import co.obrio.business.LoginBO;
import co.obrio.business.ProfileBO;
import co.obrio.model.RelationshipStatus;
import co.obrio.pages.HomePage;
import mobile.BaseTest;

public class ProfileTest extends BaseTest {

    @Test
    public void updateRelationshipStatusTest() {
        HomePage homePage = new LoginBO().performLogin();


        ProfileBO profileBO = new ProfileBO();
        profileBO.goToProfile(homePage);
        profileBO.updateRelationshipStatus(RelationshipStatus.IN_RELATIONSHIP);

        profileBO.verifyRelationshipStatusUpdate(RelationshipStatus.IN_RELATIONSHIP);
    }

    @Test
    public void updatePhoneNumberTest() {
        HomePage homePage = new LoginBO().performLogin();

        ProfileBO profileBO = new ProfileBO();
        profileBO.goToProfile(homePage);
        String newPhone = profileBO.generateRandomPhoneNumber();
        profileBO.updatePhoneNumber(newPhone);

        profileBO.verifyPhoneNumberUpdate(newPhone);
    }

    @Test
    public void updatePlaceOfBirthWithCityTest() {
        HomePage homePage = new LoginBO().performLogin();

        ProfileBO profileBO = new ProfileBO();
        profileBO.goToProfile(homePage);
        String cityToInput = "Lviv";
        String cityToSelectUkr = "Львів";
        profileBO.updatePlaceOfBirth(cityToInput, cityToSelectUkr);

        profileBO.verifyPlaceOfBirth(cityToSelectUkr);
    }

    @Test
    public void updateBirthDateTest() {
        HomePage homePage = new LoginBO().performLogin();

        ProfileBO profileBO = new ProfileBO();
        profileBO.goToProfile(homePage);
        String initialDate = profileBO.getCurrentBirthDate();
        String newDate = profileBO.generateRandomBirthDate();
        profileBO.updateBirthDate(newDate);

        profileBO.verifyBirthDateUpdate(initialDate, newDate);
    }
}