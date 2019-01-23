package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        boolean clickable=false;

        while (!clickable) {

            try {

                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                clickable = true;

            } catch (Exception e) {
                System.out.println("wait until element to be clickable");
            }
        }

    }

}
