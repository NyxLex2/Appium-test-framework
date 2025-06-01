package mobile.login;

import mobile.BaseTest;
import org.testng.annotations.Test;

import co.obrio.business.LoginValidationBO;

public class LoginValidationTest extends BaseTest {

    @Test
    public void invalidEmailFormatValidationTest() {
        LoginValidationBO loginValidationBO = new LoginValidationBO();
        loginValidationBO.validateInvalidEmailFormat();
        loginValidationBO.verifyEmailError("Enter a valid email");
    }

    @Test
    public void shortPasswordValidationTest() {
        LoginValidationBO loginValidationBO = new LoginValidationBO();
        loginValidationBO.validateShortPassword();
        loginValidationBO.verifyPasswordError("Incorrect password");
    }
}