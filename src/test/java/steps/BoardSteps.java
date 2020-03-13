package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import trello.entities.Board;
import trello.entities.Context;
import trello.menus.Menu;
import trello.pages.BoardPage;
import trello.pages.MainPage;
import trello.pages.modals.ModalBoard;

import java.util.Map;

public class BoardSteps {

    private Context context;
    private ModalBoard modalBoard;
    private Board board;

    public BoardSteps(final Context context) {
        this.context = context;
        this.board = context.getBoard();
    }

    @Given("^I am logged with valid user$")
    public void iAmLoggedWithValidUser() {
        Menu menu = new Menu();
        String expected = "OL";
        String result = menu.isUserButtonDisplayed();
        Assert.assertEquals(expected, result);
    }

    @When("^I create a new Board with name \"([^\"]*)\"$")
    public void iCreateANewBoardWithName(String nameOfBoard) {
        context.getBoard().setName(nameOfBoard);
        MainPage mainPage = new MainPage();
        mainPage.clickOnPlusButton();
        BoardPage boardPage = new BoardPage();
        modalBoard = new ModalBoard();
        modalBoard.createNewBoard(context.getBoard());
    }

    @Then("^I should see the name of Board in BoardPage$")
    public void iShouldSeeTheNameOfBoardInBoardPage() {
        BoardPage boardPage = new BoardPage();
        String expected = context.getBoard().getName();
        String actual = boardPage.boardsName();
        Assert.assertEquals(expected, actual);
    }

    @When("^I delete a existing board with \"([^\"]*)\"$")
    public void iDeleteAExistingBoardWith(String nameOfBoard) {

        context.getBoard().setName(nameOfBoard);
        BoardPage boardPage = new BoardPage();
        String name = context.getBoard().getName();
        boardPage.createBoard(name);
        boardPage.deleteBoard();
    }


    @When("^I create a new board whit following information$")
    public void iCreateANewBoardWhitFollowingInformation(final Map<String, String> boardInformation) {
        board.setBoardInformation(boardInformation);
        BoardPage boardPage = new BoardPage();
        boardPage.createBoard(board, boardInformation.keySet());
    }
}
