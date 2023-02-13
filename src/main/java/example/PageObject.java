package example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ConfigReader;
import util.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PageObject {
    protected static WebDriver driver;
    private static final int seconds = 30;
    protected String baseUrl;
    protected String environment;
    private final By spinner = By.cssSelector("[data-test='spinner']");

    PageObject() {
        environment = ConfigReader.getConfigProps("environment");
        baseUrl = ConfigReader.getEnvProps("env." + environment + ".url");
    }

    public static void setup() {
        driver = WebDriverFactory.getDriver();
        System.out.println("driver.hashCode() = " + driver.hashCode());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        WebDriverFactory.quitDriver();
    }

    public static String takeScreenshot(String fileName) {

        TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
        File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
        String path = "target/screenshots/" + fileName + ".png";
        try {
            FileUtils.copyFile(screenshot, new File(path));
        } catch (IOException e) {
            throw new RuntimeException("Screenshot failed " + e.getMessage());
        }
        return path;
    }

    public WebElement $(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> $$(By by) {
        return driver.findElements(by);
    }


    public void waitForElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void waitForElementInvisible(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForSpinner() {
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
            if ($$(spinner).size() > 0) {
                waitForElementInvisible(spinner, 120);
            }
        }
    }

    public WebElement waitForElementTOBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return $(by);
    }

    public void scrollInToView(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", $(by));
    }

    public void scrollInToView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void click(By by) {
        scrollInToView(by);
        waitForElementTOBeClickable(by);
        $(by).click();
    }

    public void click(WebElement ele) {
        scrollInToView(ele);
        ele.click();
    }

    public void JSClick(By by) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", $(by));
    }

    public void JSClick(WebElement ele) {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", ele);
    }

    public void JSEnterText(By by, String text) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].setAttribute('value', '" + text + "')", $(by));
    }

    public void wait(int timeoutInMillis) {
        try {
            Thread.sleep(timeoutInMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isVisible(By by) {
        return $$(by).size() > 0;
    }

    public void jsClick(By by) {
        WebElement element = $(by);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}

