package ru.usetech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(css = ".alert-success")
    protected WebElement alertSuccess;

    @FindBy(css =(".alert-messages .remove"))
    protected WebElement alertCloseBtn;

    public Page(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void type(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    public boolean click(WebElement element) {
        try {

            Thread.sleep(1000);

            WebDriverWait w = new WebDriverWait(driver, 5);
            w.until(elementToBeClickable(element));

            element.click();

            return true;

        } catch (Exception ex) {
            return false;

        }

    }

    public void scrollPage() {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public void waitListUpdated(String locator, int count) {
        wait.until(numberOfElementsToBeMoreThan(By.cssSelector(locator), count));
    }

    public int getElementsCount(String locator) {
        scrollPage();
        return driver.findElements(By.cssSelector(locator)).size();
    }

    public boolean isElementPresent(WebElement element) {

        try {

            wait.until(visibilityOf(element));
            return true;

        } catch (Exception ex) {

            return false;

        }
    }


    public boolean alertSuccess() {
        try {

            wait.until(visibilityOf(alertSuccess));
            click(alertCloseBtn);
            //wait.until(stalenessOf(driver.findElement(By.cssSelector(".alert-success"))));

            return true;

        } catch (Exception ex) {

            return false;

        }
    }

    public void closeAlert() {
        wait.until(visibilityOf(alertCloseBtn));
        alertCloseBtn.click();
    }

    }
