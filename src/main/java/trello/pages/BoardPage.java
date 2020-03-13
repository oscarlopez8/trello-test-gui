package trello.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entities.Board;

import java.util.HashMap;
import java.util.Set;

public class BoardPage extends BasePage {

    private static final String CSS_BUTTON_PLUS = "_3r1LXvjBp8zfAv";
    private static final String CSS_BUTTON_CREATE_A_BOARD = "_2jR0BZMM5cBReR";
    private static final String INPUT_NAME = "_23NUW98LaZfBpQ";
    private static final String SELECT_ORGANIZATION = "_1se-PM9Q1YyEtg"; //_1se-PM9Q1YyEtg
    private static final String KIND_OF_BOARD = "_1Lkx3EjS3wCrs7";
    private static final String CREATE_BOARD_BUTTON = "_3UeOvlU6B5KUnS";
    private static final String USER_BUTTON = "_24AWINHReYjNBf";
    private static final String NAMES_BOARD = "js-board-editing-target";
    private static final String MORE_BUTTON = "js-open-more";
    private static final String CLOSE_BUTTON = "js-close-board";
    private static final String TYPE_BUTTON = "_1Lkx3EjS3wCrs7";
    private static final String CLICK_ON_TYPE_BUTTON = "span._1uK2vQ_aMRS2NU";

    @FindBy(className = CSS_BUTTON_PLUS)
    WebElement buttonPlus;

    @FindBy(className = CSS_BUTTON_CREATE_A_BOARD)
    WebElement buttonCreateBoard;

    @FindBy(className = INPUT_NAME)
    WebElement inputName;

    @FindBy(className = SELECT_ORGANIZATION)
    WebElement selectOrganization;

    @FindBy(className = KIND_OF_BOARD)
    WebElement kindOfBoard;

    @FindBy(className = CREATE_BOARD_BUTTON)
    WebElement createBoardButton;

    @FindBy(className = USER_BUTTON)
    private WebElement userButton;

    @FindBy(className = NAMES_BOARD)
    private WebElement namesBoard;

    @FindBy(className = MORE_BUTTON)
    private WebElement moreButton;

    @FindBy(className = CLOSE_BUTTON)
    private WebElement closeButton;

    @FindBy(className = TYPE_BUTTON)
    private WebElement typeButton;

    @FindBy(className = CLICK_ON_TYPE_BUTTON)
    private WebElement publicButton;


    public BoardPage() {}


    public void setInputName(String name) {
        this.inputName.clear();
        this.inputName.sendKeys(name);
    }

    public void setTypeButton(String type) {
        this.typeButton.sendKeys(type);
    }

    private void clickCreateButton() {
        this.createBoardButton.click();
    }

    private void clickOnMoreButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(MORE_BUTTON)));
        this.moreButton.click();
    }

    private void clickOnCloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CLOSE_BUTTON)));
        this.closeButton.click();
    }

    public void clickOnPlusButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(CSS_BUTTON_PLUS)));
        buttonPlus.click();
        buttonCreateBoard.click();
    }

    public void createBoard(final String boardName) {
        clickOnPlusButton();
        setInputName(boardName);
        clickCreateButton();
    }

    public String boardsName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(NAMES_BOARD)));
        String names = namesBoard.getText();
        return names;
    }

    public void deleteBoard() {
        clickOnMoreButton();
        clickOnCloseButton();
    }

    private void clickOnPublicButton() {
        this.publicButton.click();
    }

    private HashMap<String, Runnable> composeStrategyMap(Board board) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();

        strategyMap.put("name", () -> setInputName(board.getName()));
        strategyMap.put("type", () ->  setTypeButton(board.getType()));
        return strategyMap;
    }

    public void createBoard(final Board board, final Set<String> fields) {
        clickOnPlusButton();
        HashMap<String, Runnable> strategyMap = composeStrategyMap(board);
        fields.forEach(field -> strategyMap.get(field).run());
        clickCreateButton();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(this.userButton));
    }
}
