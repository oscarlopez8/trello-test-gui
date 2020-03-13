package hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import trello.entities.Context;
import trello.navigatePages.NavigatePages;
import trello.pages.BoardPage;
import trello.pages.LoginPage;
import trello.pages.MainPage;
import trello.pages.TransporterPage;
import trello.pages.modals.ModalBoard;

public class Hook {

    private Context context;
    private ModalBoard modalBoard;
    private static final String userName = "oscar.lopez@fundacion-jala.org";
    private static final String userPassword = "O3728236l";
    private static final String nameOfBoard = "NewBoardList";

    public Hook(Context context) {
        this.context = context;
    }

    @Before
    public void login() {
        TransporterPage.navigateToURL(NavigatePages.getLoginPageUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.loginInToTrello(userName, userPassword);
    }

    @Before(value = "@CreateBoard")
    public void createBoard() {
        context.getBoard().setName(nameOfBoard);
        MainPage mainPage = new MainPage();
        mainPage.clickOnPlusButton();
        //BoardPage boardPage = new BoardPage();
        modalBoard = new ModalBoard();
        modalBoard.createNewBoard(context.getBoard());
    }

    @After
    public void closeDriver() {

    }




}
