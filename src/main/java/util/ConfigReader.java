package util;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader(){
    }

    private static Properties loadConfigProps(){
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    private static Properties loadEnvProps(){
        Properties prop = new Properties();
        try {
            FileInputStream ip = new FileInputStream("src/test/resources/environment.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static String getEnvProps(String key){
        return loadEnvProps().getProperty(key);
    }

    public static String getConfigProps(String key){
        return loadConfigProps().getProperty(key);
    }
}
