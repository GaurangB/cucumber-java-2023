package Steps;

import example.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import util.TestContext;
import util.UserInfo;

public class LoginSteps {

    LoginPage loginPage;
    TestContext context;

    public LoginSteps(TestContext testContext, LoginPage loginPage) {
        this.context = testContext;
        this.loginPage = loginPage;
    }

    @Given("User is already on sign in page")
    public void user_is_already_on_sign_in_page() {
        loginPage.navigateToLoginPage();

    }

    @When("user enters {} and {}")
    public void user_enters_user_name_and_password(String userName, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @Given("user is authenticated with username as {} password as {}")
    public void user_is_authenticated_with_username_and_password(String userName, String password) {
    }

    @Given("user {} is authenticated to the app")
    public void user_is_authenticated_to_the_app(String key) {
        String userName = UserInfo.getUserInfo(key).userName;
        String password = UserInfo.getUserInfo(key).password;
    }

    @When("click on signIn button")
    public void click_on_sign_in_button() {
        loginPage.clickOnSingIn();
    }


    @When("I login as {} from login page")
    public void iLoginAsAdmin(String key) {
        loginPage.enterUserName(UserInfo.getUserInfo(key).userName);
        loginPage.enterPassword(UserInfo.getUserInfo(key).password);
        loginPage.clickOnSingIn();
    }
}
