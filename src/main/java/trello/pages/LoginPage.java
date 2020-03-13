package trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String URL = "https://trello.com/login";

    public LoginPage() {
        driver.get(URL);
    }

    @FindBy(id = "user")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    /**
     * Writes in usernameField WebElement the username parameter.
     *
     * @param text is to write in usernameField WebElement.
     */
    private void setUserName(final String text) {
        userNameField.sendKeys(text);
    }

    /**
     * Writes in passwordField WebElement the password parameter.
     *
     * @param text is to write in passwordField WebElement.
     */
    private void setUserPassword(final String text) {
        passwordField.sendKeys(text);
    }

    /**
     * Clicks to submit login form.
     */
    private void clickLoginButton() {
        loginButton.click();
    }

    /**
     * Login with username and password parameter from user.
     *
     * @param userName use to get user's name.
     * @param userPassword use to get user's password.
     */
    public void loginInToTrello(final String userName, final String userPassword) {
        wait.until(ExpectedConditions.elementToBeClickable(this.userNameField));
        setUserName(userName);
        setUserPassword(userPassword);
        clickLoginButton();
    }

    /**
     * Waits to WebElement is loaded
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        //wait.until(ExpectedConditions.elementToBeClickable(this.userNameField));
    }
}
