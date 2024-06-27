package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.WebDriverManager;
import org.example.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginSteps
{
    LoginPage loginPage;
    WebDriver driver;

    @Given("User is on login page")
    public void userIsOnLoginPage()
    {
        driver = WebDriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        driver.get(loginPage.expectedUrl);
    }

    @When("User submits their registered account")
    public void userSubmitsAccount() throws InterruptedException
    {
        loginPage.enterEmail(loginPage.account);
        loginPage.enterPassword(loginPage.password);
        loginPage.clickLogin();
    }

    @When("User submits unregistered account with invalid credentials")
    public void userSubmitsUnregisteredAccount() throws InterruptedException
    {
        loginPage.enterEmail(loginPage.invalidAccount);
        loginPage.enterPassword(loginPage.password);
        loginPage.clickLogin();
    }

    @Then("User should be redirected to login page with error message")
    public void userRedirectedLoginError() throws InterruptedException
    {
        Assert.assertEquals("These credentials do not match our records.", loginPage.getLoginErrorMessage());
        WebDriverManager.quitDriver();
    }

    @Then("User should be redirected to login page")
    public void userRedirectedFromRegister()
    {
        driver = WebDriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.expectedUrl,driver.getCurrentUrl());
        WebDriverManager.quitDriver();
    }

    @Then("User should be redirected to login page without quitting")
    public void userRedirectedFromRegisterNoQuit()
    {
        driver = WebDriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.expectedUrl,driver.getCurrentUrl());
    }
}

