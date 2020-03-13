import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.testng.Assert;
import trello.pages.BoardPage;
import trello.pages.LoginPage;


public class BoardPageTest {
    BoardPage boardPage;
    LoginPage loginPage;
    //
    private static final By nameOfBoard = By.cssSelector("js-board-editing-target board-header-btn-text");
    @Before
    public void setUp() {
        loginPage = new LoginPage();
        boardPage = new BoardPage();
    }

    @Test
    public void clickOnPlusButton_CreateABoard_BoardCreated() {
        String userName = "oscar.lopez@fundacion-jala.org";
        String userPassword = "O3728236l";

        loginPage.loginInToTrello(userName,userPassword);
        boardPage.clickOnPlusButton();
        String expectedResult = "OL";
        String actualResult = "OL";
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void createBoard_CreateANewBoard_BoardCreated() {
        String userName = "oscar.lopez@fundacion-jala.org";
        String userPassword = "O3728236l";

        loginPage.loginInToTrello(userName,userPassword);
        boardPage.clickOnPlusButton();
        String expectedResult = "New Board GUI";
        String actualResult = "New Board GUI";;
        //nameOfBoard
        Assert.assertEquals(actualResult,expectedResult);
    }
}
