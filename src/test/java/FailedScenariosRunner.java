import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        plugin = {"pretty", "html:target/cucumber_rerun.html"}
)
public class FailedScenariosRunner {
    
}