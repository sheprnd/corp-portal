package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GeneralList extends List {

    public GeneralList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".categories > div.table__line:nth-child(2)")
    private WebElement firstRow;

    public int elementsCount() {

        wait.until(visibilityOf(firstRow));
        scrollList();
        return driver.findElements(By.cssSelector(".categories > div.table__line")).size();

    }

}
