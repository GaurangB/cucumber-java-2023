package example;

import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private final By user = By.cssSelector("[data-test='username']");
    private final By password = By.cssSelector("[data-test='password']");
    private final By clickButton = By.cssSelector("[data-test='login-button']");

    public void enterUserName(String userName) {
        waitForElementTOBeClickable(user).sendKeys(userName);
    }

    public void enterPassword(String password) {
        $(this.password).sendKeys(password);
    }

    public void clickOnSingIn() {
        $(clickButton).click();
        waitForSpinner();
    }

    public void navigateToLoginPage() {
        driver.get(baseUrl);
    }
}
