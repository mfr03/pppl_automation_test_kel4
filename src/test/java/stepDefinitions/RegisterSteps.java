package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.WebDriverManager;
import org.example.pages.RegisterPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterSteps
{
    RegisterPage registerPage;
    WebDriver driver;


    @Given("User is on the register page")
    public void userIsOnRegisterPage()
    {
        driver = WebDriverManager.getDriver();
        this.registerPage = new RegisterPage(driver);

        driver.get("http://127.0.0.1:8000/register");
    }

    @When("User submits their account credentials")
    public void userSubmitsAccountCredentials() throws InterruptedException
    {
        registerPage.entername(registerPage.name);
        registerPage.enterEmail(registerPage.account);
        registerPage.enterPassword(registerPage.password);
        registerPage.enterConfirmationPassword(registerPage.password);
        registerPage.selectCompany(registerPage.companyIndex);
        registerPage.clickRegister();
    }

    @When("User submits already registered account")
    public void userSubmitsRegisteredAccount() throws InterruptedException
    {
        registerPage.entername(registerPage.name);
        registerPage.enterEmail(registerPage.errorAccount);
        registerPage.enterPassword(registerPage.password);
        registerPage.enterConfirmationPassword(registerPage.password);
        registerPage.selectCompany(registerPage.companyIndex);
        registerPage.clickRegister();
    }

    @Then("User should be redirected to register page with error message")
    public void userRedirectedRegisterPageError() throws InterruptedException
    {
        Assert.assertEquals("The email has already been taken.", registerPage.getRegisterErrorMessage());
        WebDriverManager.quitDriver();
    }


}
