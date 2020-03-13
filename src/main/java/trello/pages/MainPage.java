package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.menus.Menu;
import trello.pages.modals.ModalBoard;

public class MainPage extends BasePage {

    private Menu menu;
    private ModalBoard modalBoard;
    private static final String DIV_CLASS_LIST = "div.js-list:nth-child(1)>div:nth-child(1)>div:nth-child(1)>div:nth-child(1)";
    //
    private static final String SPAN_CLASS = "_24AWINHReYjNBf";
    private static final String DIV_CSS = "div[title='%s']";

    private static final String DIV_CLASS_USER_NAME = "_1FekJJAz6Hu32v";

    private static final String CSS_BUTTON_PLUS = "span._2BQG4yPMt5s_hu._2hgn5meZL7bJdx._3r1LXvjBp8zfAv._1iYprMLTeGpyW9";
    private static final String CSS_BUTTON_CREATE_A_BOARD = "button._2jR0BZMM5cBReR";

    @FindBy(className = SPAN_CLASS)
    private WebElement fullNameButton;

    @FindBy(css = CSS_BUTTON_PLUS)
    WebElement buttonPlus;

    @FindBy(css = CSS_BUTTON_CREATE_A_BOARD)
    WebElement buttonCreateBoard;

    public MainPage() {
        super();
        menu = new Menu();
    }

    public Menu getMenu() {
        return menu;
    }

    /**
     * Clicks on User Button.
     *
     */
    public String findUserName() {
        fullNameButton.click();
        String classNameText = driver.findElement(By.className("_24AWINHReYjNBf")).getText();
        return classNameText;
    }

    /**
     * Goes to the board page.
     *
     * @param boardTitle is the title of the board.
     */
    public void clickOnABoard(final String boardTitle) {
        String boardCss = String.format(DIV_CSS, boardTitle);
        WebElement boardButton = driver.findElement(By.cssSelector(boardCss));
        boardButton.click();
     }

    public ModalBoard clickOnPlusButton() {
        buttonPlus.click();
        buttonCreateBoard.click();
        return modalBoard;
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(buttonPlus));
    }
}
