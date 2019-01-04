import lombok.Getter;
import lombok.extern.log4j.Log4j;

import java.io.InputStream;
import java.util.Properties;

import static java.lang.ClassLoader.getSystemResourceAsStream;

@Log4j
@Getter
public class ResourceLoader {

    static final String appPropertiesFileName = "application.properties";

    public static String loadAppProperty(String name) {
        return loadProperty(name, appPropertiesFileName);
    }


    public static String loadProperty(String name, String filename) {
        String propertyValue = "";
        Properties prop = new Properties();

        try (InputStream is = getSystemResourceAsStream(filename)) {
            prop.load(is);
        } catch (Exception e) {
            log.error("Failed to get property:" + name, e);
        }

        if (name != null) {
            propertyValue = prop.getProperty(name);
        }
        return propertyValue;

    }
}
