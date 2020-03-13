package trello.menus;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.pages.BasePage;

public class Menu extends BasePage {
    @FindBy(className = "_24AWINHReYjNBf")
    private WebElement userButton;

    @FindBy(className = "_1q-xxtNvcdFBca")
    private WebElement trelloLogo;

    /**
     * Verifies if the user button is displayed.
     *
     * @return true if the user button is displayed.
     */
    public String isUserButtonDisplayed() {
        String answer = null ;
            System.out.println(userButton.getText());
            answer = userButton.getText();
        return answer;
    }

    /**
     * Waits to that element is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(trelloLogo));
    }
}
