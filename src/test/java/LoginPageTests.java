import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import trello.pages.LoginPage;

public class LoginPageTests {
    LoginPage loginPage;
    @Before
    public void setUp() {
        loginPage = new LoginPage();
    }

    @After
    public void tearDown() {
        //WebDriverManager.getInstance().quitDriver();
    }

    @Test
    public void loginInToTrello_LoginWithUserAndPassword_LoginSuccessful() {

        String userName = "oscar.lopez@fundacion-jala.org";
        String userPassword = "O3728236l";
        loginPage.loginInToTrello(userName,userPassword);
        //Assert.assertEquals("Tableros | Trello", driver.getTitle());
        //Assert.assertTrue(test);
    }
}
