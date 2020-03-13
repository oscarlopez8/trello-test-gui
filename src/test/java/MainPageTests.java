import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import trello.pages.LoginPage;
import trello.pages.MainPage;


public class MainPageTests {

    MainPage mainPage;
    LoginPage loginPage;
    WebDriver driver;

    @After
    public void tearDown() {
        //WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void clickOnUserButton_ClickOnUserButton_WindowShouldBeDisplayed() {

        loginPage = new LoginPage();
        String userName = "oscar.lopez@fundacion-jala.org";
        String userPassword = "O3728236l";
        loginPage.loginInToTrello(userName,userPassword);
        mainPage = new MainPage();
        String classUser = "oscarNew";
        mainPage.clickOnABoard(classUser);
        //String url = driver.getCurrentUrl();
    }

    @Test
    public void clickOnUserButton_FindUserName_DisplayUserName() {
        loginPage = new LoginPage();
        String userName = "oscar.lopez@fundacion-jala.org";
        String userPassword = "O3728236l";
        loginPage.loginInToTrello(userName,userPassword);
        mainPage = new MainPage();
        String actualResult = mainPage.findUserName();
        String expectedResult = "OL";
        Assert.assertEquals(actualResult,expectedResult);
    }
}
