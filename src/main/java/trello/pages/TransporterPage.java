package trello.pages;

import core.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TransporterPage {
    private static WebDriver driver = WebDriverManager.getInstance().getWebDriver();

    /**
     * Navigate to URL use and and point.
     *
     * @param uriPage Gets a uri.
     */
    public static void navigateToURL(final String uriPage) {
        try {
            driver.navigate().to(uriPage);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
