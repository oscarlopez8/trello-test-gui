package core;

import core.factory.Chrome;
import core.factory.FireFox;
import core.factory.IDriver;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverFactory {
    private static Map<String, IDriver> browsers = new HashMap<>();
    static {
        browsers.put("chrome", new Chrome());
        browsers.put("firefox", new FireFox());
    }

    /**
     * Uses for select a Browser.
     *
     * @param browser Parameter content a Browser Name.
     * @return a webDriver.
     */
    public static WebDriver getWebDriver(final String browser) {
        return browsers.get(browser).initDriver();
    }
}
