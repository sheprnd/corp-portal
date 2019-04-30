package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TimesheetsList extends Page {

    public TimesheetsList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".default-shedule")
    private WebElement firstRow;

    public int count() {

        wait.until(visibilityOf(firstRow));
        return getElementsCount(".timesheet-rows .grid-im__wrap");

    }

    public void waitListUpdated(int count) {

        wait.until(numberOfElementsToBeMoreThan(By.cssSelector(".timesheet-rows .grid-im__wrap"), count));
    }

    public String getValueFromTheCell(int cellIndex) {

        WebElement cell = driver.findElement(By.cssSelector(".default-shedule .timesheet-rows .grid__col-index_" + cellIndex));
        return cell.getText();
    }
}
