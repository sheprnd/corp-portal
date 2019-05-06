package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GeneralList extends Page {

    public GeneralList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".categories div.table__line")
    private WebElement firstRow;

    public int elementsCount() {

        wait.until(visibilityOf(firstRow));
        return getElementsCount(".categories div.table__line");

    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(".categories div.table__line", count, operationType);
    }

    public String getElementName(int index) {
        return driver.findElement(By.cssSelector(".categories div.table__line:nth-child(" + (index + 1) + ")")).getText();
    }
}
