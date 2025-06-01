package mobile;

import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import co.obrio.core.DriverManager;

public class BaseTest {
    private static Properties properties = null;

    @BeforeClass
    public void setUp() {
        setProperties();
        try {
            DriverManager.initializeDriver(properties);
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize driver", e);
        }
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quitDriver();
    }

    private void setProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties");
                if (input == null) {
                    throw new RuntimeException("config.properties not found in classpath");
                }
                properties.load(input);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load properties", e);
            }
        }
    }
}
