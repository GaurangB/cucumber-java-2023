package Steps;

import example.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import util.TestContext;

public class HomeSteps {
    private final HomePage homePage;
    TestContext context;

    public HomeSteps(TestContext testContext, HomePage homePage) {
        this.context = testContext;
        this.homePage = homePage;
    }

    @Then("user navigates to homePage")
    public void user_navigates_to_home_page() {
        Assert.assertFalse(homePage.isHomePageDisplayed());
    }
}
