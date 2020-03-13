package trello.pages;

import core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor of BasePage class.
     */
    public BasePage() {
        this.driver = WebDriverManager.getInstance().getWebDriver();
        this.wait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(driver, this);
        waitUntilPageObjectIsLoaded();
    }

    /**
     * Waits until a webElement is loaded.
     */
    protected abstract void waitUntilPageObjectIsLoaded();
}
