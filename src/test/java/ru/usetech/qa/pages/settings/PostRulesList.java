package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PostRulesList extends Page {

    public PostRulesList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".rules.left > div:first-child > .rules__line:nth-child(2)")
    private WebElement firstRow;

    public int count() {

        wait.until(visibilityOf(firstRow));
        return getElementsCount(".rules.left > div:first-child > .rules__line");

    }

    public void waitListUpdated(int count) {

        wait.until(numberOfElementsToBeMoreThan(By.cssSelector(".rules.left > div:first-child > .rules__line"), count));
    }
}
