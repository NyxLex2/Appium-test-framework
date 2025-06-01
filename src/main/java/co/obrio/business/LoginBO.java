package co.obrio.business;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import co.obrio.pages.GetStartedPage;
import co.obrio.pages.LoginPage;
import co.obrio.pages.HomePage;

public class LoginBO {
    private Properties properties;

    public LoginBO() {
        loadProperties();
    }

    private void loadProperties() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public HomePage performLogin() {
        LoginPage loginPage = new GetStartedPage().clickLogin().clickUsingEmailButton();
        loginPage.enterEmail(properties.getProperty("email"));
        loginPage.enterPassword(properties.getProperty("password"));
        loginPage.clickLoginButton();
        return new HomePage();
    }
}