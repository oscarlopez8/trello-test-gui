package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import trello.entities.Context;
import trello.entities.List;
import trello.pages.ListPage;
import trello.pages.MainPage;

public class ListStep {

    Context context;
    MainPage mainPage;
    ListPage listPage;

    /**
     * Shares states between objects.
     *
     * @param context has share entities.
     */
    public ListStep(final Context context) {
        this.context = context;
    }

    @When("^I select a board with name \"([^\"]*)\"$")
    public void iSelectABoardWithName(final String nameOfBoard) {
        mainPage = new MainPage();
        mainPage.clickOnABoard(nameOfBoard);
        context.getBoard().setName(nameOfBoard);
    }

    @And("^I creat a new list with name \"([^\"]*)\"$")
    public void iCreatANewListWithName(final String listName) {
        context.getList().setTitle(listName);

        List list = new List();
        context.setList(list);

        ListPage listPage = new ListPage();
        listPage.writeOnListName(listName);

        listPage.clickOnAddNewList();

    }

    @Then("^I should see the name of new list on board$")
    public void iShouldSeeTheNameOfNewListOnBoard() {
        ListPage listPage = new ListPage();
        String expected = context.getList().getTitle();
        String actual = listPage.listName();
        Assert.assertEquals(expected, actual);
    }
}
