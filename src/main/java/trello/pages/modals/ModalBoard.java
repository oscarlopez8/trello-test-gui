package trello.pages.modals;

import core.util.WebDriverAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entities.Board;
import trello.pages.BasePage;

public class ModalBoard extends BasePage {
    @FindBy(css = "div._2RESlz4Z1kkkKj")
    private WebElement backgroundContain;

    @FindBy(css = "input._23NUW98LaZfBpQ")
    private WebElement nameBoardField;

    @FindBy(css = "button._3UeOvlU6B5KUnS")
    private WebElement createBoardButton;

    /**
     * Waits until a web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(backgroundContain));
    }

    /**
     * Creates new Board from a instance of Board class.
     *
     * @param board is to get required data.
     */
    public void createNewBoard(final Board board) {
        WebDriverAction.setTxtElement(nameBoardField, board.getName());
        WebDriverAction.clickButton(driver, createBoardButton);
    }
}
