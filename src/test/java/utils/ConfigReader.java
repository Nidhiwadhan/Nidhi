package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {
        try {
            InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties NOT FOUND");
            }

            prop.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file", e);
        }
    }

    public static String getBrowser() {
        return prop.getProperty("browser");
    }

    public static String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public static int getTimeout() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(prop.getProperty("headless"));
    }

    public static boolean isSauce() {
        return Boolean.parseBoolean(prop.getProperty("sauce"));
    }
}