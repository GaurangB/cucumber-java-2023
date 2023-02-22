package Steps.Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.WebDriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    @Before("@ui")
    public void setup1(Scenario scenario) {
        LOG.info(scenario.getName() + " Started.");
    }

    @After("@ui")
    public void cleanup(Scenario scenario) {
        LOG.info(scenario.getName() + " Failed? " + scenario.isFailed());
        if (scenario.isFailed()) {
            String fileName = scenario.getName() + System.currentTimeMillis() / 1000;

            TakesScreenshot screenshotDriver = (TakesScreenshot) WebDriverFactory.getDriver();
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
            String path = "target/screenshots/" + fileName + ".png";
            try {
                FileUtils.copyFile(screenshot, new File(path));
            } catch (IOException e) {
                throw new RuntimeException("Screenshot failed " + e.getMessage());
            }
            try {
                scenario.attach(Files.readAllBytes(screenshot.toPath()), "image/png", fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        WebDriverFactory.quitDriver();
    }
}


