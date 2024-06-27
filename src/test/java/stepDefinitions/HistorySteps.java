package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.WebDriverManager;
import org.example.pages.HistoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HistorySteps
{
    HistoryPage historyPage;
    WebDriver driver;

    @Given("User is on history page")
    public void userIsOnHistoryPage()
    {
        driver = WebDriverManager.getDriver();
        this.historyPage = new HistoryPage(driver);
        driver.get("http://127.0.0.1:8000/history");
    }

    @When("User chose their chosen drill")
    public void userChoseDrill() throws InterruptedException
    {
        historyPage.selectWell(8);
        historyPage.selectSensor(1);
    }

    @When("User enters range for the historical data")
    public void userEnterRange() throws InterruptedException
    {
        historyPage.selectDate(1);
        historyPage.insertTime("05:00 - 05:20");
        historyPage.search();
    }

    @Then("User should be shown the historical data")
    public void userShownData() throws InterruptedException
    {
        Assert.assertEquals("608", historyPage.getBitdepth());
        WebDriverManager.quitDriver();
    }
}
