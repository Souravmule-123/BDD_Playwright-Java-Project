package dataReader;

import enums.DriverType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.Properties;

import static appData.Constant.PROPERTY_FILE_PATH;

public class ConfigFileReader {

    private final Properties properties;

    // ✅ LOCAL LOGGER (correct way)
    private static final Logger log =
            LoggerFactory.getLogger(ConfigFileReader.class);

    public ConfigFileReader() {
        properties = new Properties();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {

            properties.load(reader);

        } catch (IOException e) {
            log.error("Failed to load config file", e);
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public String getApplicationUrl(String key) {
        String url = properties.getProperty(key);

        if (url == null) {
            log.error("URL not found for key: {}", key);
            throw new RuntimeException("URL not found for key: " + key);
        }

        log.info("Application URL is: {}", key);
        return url;
    }

    // ---------------- Credentials ----------------

    public String getSauceDemoUserName(String user) {
        return getRequiredProperty("Username");
    }

    public String getSauceDemoPwd(String pwd) {
        return getRequiredProperty("Password");
    }

    // ---------------- Browser ----------------

    public DriverType getBrowser() {

        String browserName =
                properties.getProperty("browser", "chrome").toLowerCase();

        DriverType type = switch (browserName) {
            case "chrome" -> DriverType.CHROME;
            case "firefox" -> DriverType.FIREFOX;
            case "none" -> DriverType.NONE;
            case "chromeheadless" -> DriverType.CHROMEHEADLESS;
            case "edge", "msedge" -> DriverType.EDGE;
            case "chromeincognito" -> DriverType.CHROMEINCOGNITO;
            default -> throw new IllegalArgumentException("Invalid browser: " + browserName);
        };

//        log.info("Browser selected from config: {}", type);
        return type;
    }

    // ---------------- Helper ----------------

    private String getRequiredProperty(String key) {
        String value = properties.getProperty(key);

        if (value == null) {
            log.error("Missing property in config: {}", key);
            throw new InvalidParameterException(key + " not specified in config file");
        }

        return value;
    }
}