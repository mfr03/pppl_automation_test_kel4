package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.WebDriverManager;
import org.example.pages.DashboardPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class DashboardSteps
{
    DashboardPage dashboardPage;
    WebDriver driver;

    @Then("User should be redirected to dashboard page")
    public void userOnDashboardPage()
    {
        driver = WebDriverManager.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.expectedUrl, dashboardPage.getActualUrl());
        WebDriverManager.quitDriver();
    }

    @Then("User should be redirected to dashboard page without quitting")
    public void userOnDashboardPageNoQuit()
    {
        driver = WebDriverManager.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        Assert.assertEquals(dashboardPage.expectedUrl, dashboardPage.getActualUrl());
    }

    @Given("User is on dashboard page")
    public void userIsOnDashbordPage()
    {
        driver = WebDriverManager.getDriver();
        this.dashboardPage = new DashboardPage(driver);
        driver.get("http://127.0.0.1:8000/dashboard");
    }

    @When("User chose their drill")
    public void userChoseDrill() throws InterruptedException
    {
        dashboardPage.selectWell(8);
        dashboardPage.selectSensor(1);
    }

    @Then("User should be redirected shown that drill realtime data")
    public void userRealtimeChart() throws InterruptedException
    {
        Assert.assertEquals(dashboardPage.expectedRealtimeUrl, dashboardPage.getActualUrl());
        Thread.sleep(500);
        WebDriverManager.quitDriver();
    }

}
