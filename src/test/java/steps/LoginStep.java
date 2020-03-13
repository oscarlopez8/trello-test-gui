package steps;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entities.Context;
import trello.entities.User;
import trello.navigatePages.NavigatePages;
import trello.pages.LoginPage;
import trello.pages.MainPage;
import trello.pages.TransporterPage;

public class LoginStep {

    private Context context;

     /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public LoginStep(final Context currentContext) {
        this.context = currentContext;
    }

    @Given("^I am on the login page$")
    public void iAmOnTheLoginPage() {
        TransporterPage.navigateToURL(NavigatePages.getLoginPageUrl());
    }

    @When("^I set user and password with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSetUserAndPasswordWithAnd(String email, String password) throws Throwable {
        User user = new User();
        context.setUser(user);
        TransporterPage.navigateToURL(NavigatePages.getLoginPageUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.loginInToTrello(email, password);
    }

    @Then("^I should be on the users home page$")
    public void iShouldBeOnTheUsersHomePage() {
        MainPage mainPage = new MainPage();
        String Expected= "OL" ;
        String result = mainPage.findUserName();
        Assert.assertEquals(Expected, result);
    }
}
