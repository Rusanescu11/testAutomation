package Utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {

    //metoda care citeste un fisier
    public static String getGenericElement(String configFile, String propertyName, String defaultValue) {
        String results = defaultValue;
        try {
            Properties appProp = new Properties();
            //Paths = ia calea automat, nu o mai punem manual
            appProp.load(Files.newInputStream(Paths.get(configFile)));
            results = appProp.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return results;
    }

    public static String getGenericElement(String configFile, String propertyName) {
        return getGenericElement(configFile, propertyName, "");
    }
}
