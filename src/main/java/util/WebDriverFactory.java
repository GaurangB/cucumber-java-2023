package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = ConfigReader.getConfigProps("browser");
            switch (browser) {
                case "chrome":
                    String chromeDriverPath = ConfigReader.getConfigProps("chromedriver.path");
                    System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                    driver.set(new ChromeDriver());
                    break;
                case "edge":
                    String edgeDriverPath = ConfigReader.getConfigProps("edgedriver.path");
                    System.setProperty("webdriver.edge.driver", edgeDriverPath);
                    driver.set(new EdgeDriver());
                    break;
                case "firefox":
                    String firefoxDriverPath = ConfigReader.getConfigProps("firefoxdriver.path");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                    driver.set(new FirefoxDriver());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser: " + browser);
            }
        }
        return driver.get();
    }

    public static void setDriver(WebDriver webDriver){
        driver.set(webDriver);
    }

    public static void quitDriver() {
        System.out.println("driver.hashCode() = " + driver.hashCode());
        driver.get().quit();
        driver.remove();
    }
}