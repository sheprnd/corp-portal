package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class UsersList extends List {

    public UsersList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".users > div:first-child .post__avatar")
    private WebElement firstRow;

    public int count() {

        wait.until(visibilityOf(firstRow));
        scrollList();
        return driver.findElements(By.cssSelector(".users .grid-im__wrap")).size();

    }
}
