package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage
{
    WebDriver driver;
    WebDriverWait wait;
    By emailTextField = By.id("email");
    By passwordTextField = By.id("password");

    By loginButton = By.xpath("/html/body/form/div/div/button");

    By loginError = By.xpath("//*[text()='These credentials do not match our records.']");
    public String account = "aaa@gmail.com";
    public String invalidAccount = "brisket@gmail.com";
    public String password = "12345678";
    public String expectedUrl = "http://127.0.0.1:8000/login";


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(2000));
    }

    private WebElement elementToVisible(By element) throws InterruptedException
    {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickLogin() throws InterruptedException
    {
        elementToVisible(loginButton).click();
    }

    public void enterEmail(String email) throws InterruptedException
    {
        elementToVisible(emailTextField).sendKeys(email);
    }

    public void enterPassword(String password) throws InterruptedException
    {
        elementToVisible(passwordTextField).sendKeys(password);
    }

    public String getLoginErrorMessage() throws InterruptedException
    {
        return elementToVisible(loginError).getText();
    }
}
