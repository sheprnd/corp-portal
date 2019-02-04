package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

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
            System.out.println("Clicked " + element);
                
            return true;

        } catch (Exception ex) {
            System.out.println("Нифига не кликнулся " + element.toString());
            return false;

        }


    }

    public boolean isElementPresent(WebElement element) {

        try {

            wait.until(visibilityOf(element));
            return true;

        } catch (Exception ex) {

            return false;

        }

    }
}
