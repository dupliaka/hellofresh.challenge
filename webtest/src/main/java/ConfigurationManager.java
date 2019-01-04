import com.codeborne.selenide.Configuration;
import lombok.Getter;

@Getter
public class ConfigurationManager {
    private static final String baseUrl;

    static {
        baseUrl = getProperty("selenide.baseUrl");
        Configuration.timeout = 5000;
        Configuration.baseUrl = baseUrl;
    }

    public static String getProperty(String propertyName) {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue == null) {
            propertyValue = ResourceLoader.loadAppProperty(propertyName);
        }
        return propertyValue;
    }

}

