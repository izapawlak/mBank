package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;

    public PropertiesReader() {
        properties = new Properties();

        try (final InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getAppUrl() {
        return properties.getProperty("appUrl");
    }

}