package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage
{
    WebDriver driver;
    WebDriverWait wait;

    By wellDropdown = By.id("wellDropdown");
    By sensorDropdown = By.id("sensorDropdown");

    public String expectedUrl = "http://127.0.0.1:8000/dashboard";
    public String expectedRealtimeUrl = "http://127.0.0.1:8000/dashboard/well/8/1";
    public DashboardPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofMillis(2000));
    }
    private WebElement elementToVisible(By element) throws InterruptedException
    {
        Thread.sleep(500);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void selectWell(int wellIndex) throws InterruptedException
    {
        Select dropdown = new Select(elementToVisible(wellDropdown));
        dropdown.selectByIndex(wellIndex);
    }

    public void selectSensor(int sensorIndex) throws InterruptedException
    {
        Select dropdown = new Select(elementToVisible(sensorDropdown));
        dropdown.selectByIndex(sensorIndex);
    }
    public String getActualUrl()
    {
        return driver.getCurrentUrl();
    }
}
