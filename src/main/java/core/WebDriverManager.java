package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {

    // Content WebDriverManager.
    private static WebDriverManager webDriverManager;

    // Content WebDriver.
    private WebDriver webDriver;

    // Content WebDriverWait.
    private WebDriverWait webDriverWait;

    /**
     * this method is used for initializes the variables.
     */
    private WebDriverManager() {
        initializes();
    }

    /**
     * This method is used for instantiate the WebDriverManager class.
     *
     * @return a webDriverManager.
     */
    public static WebDriverManager getInstance() {

        if (webDriverManager == null || webDriverManager.webDriver == null ) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * This method is used for initializes the variables.
     */
    private void initializes() {
        this.webDriver = WebDriverFactory.getWebDriver(WebDriverConfig.getInstance().getBrowser());
        this.webDriver.manage().window().maximize();
        this.webDriver.manage().timeouts().implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(),
                TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getExplicitWaitTime(),
                WebDriverConfig.getInstance().getSleepWait());
    }

    /**
     * Uses to get a WebDriver.
     *
     * @return a WebDriver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Uses to get a WebDriverWait.
     *
     * @return a WebDriverWait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void quitDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
