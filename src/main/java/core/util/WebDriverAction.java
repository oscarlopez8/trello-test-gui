package core.util;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class WebDriverAction {
    private static HashMap<String, By> byLocator = new HashMap<>();

    private WebDriverAction() {

    }

    /**
     * Sets text in the WebElement object.
     *
     * @param webElement to set its text.
     * @param text       is the new value to send in sendKeys parameter.
     */
    public static void setTxtElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Does click in the button element when it is clickable.
     *
     * @param webDriver  use to set up WebDriverWait.
     * @param webElement use to search the webElement.
     */
    public static void clickButton(final WebDriver webDriver, final WebElement webElement) {
        waitElementBeClickable(webDriver, webElement);
        webElement.click();
    }

    /**
     * Waits until webElement will be clickable.
     *
     * @param webDriver  use to set up WebDriverWait.
     * @param webElement use to search the webElement.
     */
    public static void waitElementBeClickable(final WebDriver webDriver, final WebElement webElement) {
        final long time = 2;
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, time);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException e) {
            throw new ElementClickInterceptedException("This element could not be clickable: " + webElement);
        }
    }
}
