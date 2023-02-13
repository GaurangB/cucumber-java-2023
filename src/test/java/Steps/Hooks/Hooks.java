package Steps.Hooks;

import example.PageObject;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Hooks {
    private static final Logger LOG = LoggerFactory.getLogger(Hooks.class);

    @Before("@ui")
    public void setup1(Scenario scenario) {
        LOG.info(scenario.getName() + " Started.");
        PageObject.setup();
    }

    @After("@ui")
    public void cleanup(Scenario scenario) {
        LOG.info(scenario.getName() + " Failed? " + scenario.isFailed());
        if (scenario.isFailed()) {
            String fileName = scenario.getName() + System.currentTimeMillis() / 1000;
            String filePath = PageObject.takeScreenshot(fileName);
            File file = new File(filePath);
            try {
                scenario.attach(Files.readAllBytes(file.toPath()), "image/png", fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PageObject.tearDown();
    }
}


