package ru.usetech.qa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public Page(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    public void type(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    public void click(WebElement element) {

        WebDriverWait w = new WebDriverWait(driver, 15);

                w.until(ExpectedConditions.elementToBeClickable(element));
                element.click();

    }

}
