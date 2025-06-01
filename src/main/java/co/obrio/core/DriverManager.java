package co.obrio.core;

import java.net.URL;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverManager {
    private static ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static Properties properties;

    public static void initializeDriver(Properties props) throws Exception {
        properties = props;
        URL appiumServer = new URL(properties.getProperty("appium.server.url"));

        UiAutomator2Options options = new UiAutomator2Options();
        options.setCapability("platformName", properties.getProperty("platform.name"));
        options.setCapability("platformVersion", properties.getProperty("platform.version"));
        options.setCapability("deviceName", properties.getProperty("device.name"));
        options.setCapability("automationName", properties.getProperty("automationName"));
        options.setCapability("app", properties.getProperty("app.path"));
        driver.set(new AndroidDriver(appiumServer, options));
    }

    public static AndroidDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}