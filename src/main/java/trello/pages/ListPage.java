package trello.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListPage extends BasePage {

    private static final String NAME_INPUT = "name";

    @FindBy(name = NAME_INPUT)
    WebElement textName;

    @FindBy(className = "js-save-edit")
    private WebElement buttonAddNewList;

    @FindBy(xpath = "//*[@id='board']/div[1]/div/div[1]/h2")
    private WebElement listName;
    /**
     * Writes in listNameField WebElement.
     *
     * @param text is to write in listNameField WebElement.
     */
    private void setListName(final String text) {
        textName.sendKeys(text);
    }

    public void writeOnListName(final String nameList) {
        setListName(nameList);
    }

    public void clickOnAddNewList() {
        this.buttonAddNewList.click();
    }

    public String listName() {
        wait.until(ExpectedConditions.elementToBeSelected(listName));
        String name = listName.getText();
        return name;
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(this.textName));
    }
}
