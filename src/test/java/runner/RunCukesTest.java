package runner;

import core.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import trello.navigatePages.NavigatePages;
import trello.pages.LoginPage;
import trello.pages.TransporterPage;
import trello.report.ReportGenerator;


@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"},
        glue = {"steps", "hooks"},
        features = {"src/test/resources/features"},
        monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static final String userName = "oscar.lopez@fundacion-jala.org";
    private static final String userPassword = "O3728236l";

    @BeforeTest
    public void beforeExecution() {
        final String BASE_URI = "https://trello.com/es";

        TransporterPage.navigateToURL(NavigatePages.getLoginPageUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.loginInToTrello(userName, userPassword);
    }

    @AfterTest
    public void afterExecution() {
        WebDriverManager.getInstance().quitDriver();
        ReportGenerator.getInstance().generateReport();
    }
}
