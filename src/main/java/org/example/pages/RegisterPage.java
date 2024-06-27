package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage
{
    WebDriver driver;
    WebDriverWait wait;
    By nameTextField = By.id("name");
    By emailTextField = By.id("email");
    By passwordTextField = By.id("password");
    By passwordConfirmation = By.id("password_confirmation");
    By selectCompany = By.id("company_id");
    By registerButton = By.xpath("/html/body/form/div/div/div[7]/button");
    By registerError = By.xpath("//*[text()='The email has already been taken.']");


    public String name = "name";
    public String account = "abc@gmail.com";
    public String errorAccount = "aaa@gmail.com";
    public String password = "12345678";
    public int companyIndex = 1;

    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(2000));
    }
    private WebElement elementToVisible(By element) throws InterruptedException
    {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void clickRegister() throws InterruptedException
    {
        elementToVisible(registerButton).click();
    }

    public void entername(String name) throws InterruptedException
    {
        elementToVisible(nameTextField).sendKeys(name);
    }

    public void enterEmail(String email) throws InterruptedException
    {
        elementToVisible(emailTextField).sendKeys(email);
    }

    public void enterPassword(String password) throws InterruptedException
    {
        elementToVisible(passwordTextField).sendKeys(password);
    }

    public void enterConfirmationPassword(String password) throws InterruptedException
    {
        elementToVisible(passwordConfirmation).sendKeys(password);
    }

    public void selectCompany(int companyIndex) throws InterruptedException
    {
        Select dropdown = new Select(elementToVisible(selectCompany));
        dropdown.selectByIndex(companyIndex);
    }

    public String getRegisterErrorMessage() throws InterruptedException
    {
        return elementToVisible(registerError).getText();
    }

}
