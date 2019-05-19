package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.TimesheetData;
import ru.usetech.qa.pages.Page;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TimesheetsList extends Page {

    private final String timesheetRowLocator = ".timesheet-rows .grid-im__wrap";

    public TimesheetsList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".default-shedule")
    private WebElement firstRow;

    public int count() {

        wait.until(visibilityOf(firstRow));
        return getTimesheets().size();

    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(timesheetRowLocator, count, operationType);
    }

    public String getValueFromTheCell( int rowIndex, int cellIndex) {
        WebElement cell = driver.findElement(By.cssSelector(".timesheet-rows > div:nth-child("
                + rowIndex + ")" + " .grid__col-index_" + cellIndex));
        return cell.getText();
    }

    private List<WebElement> getTimesheets(){
        return driver.findElements(By.cssSelector(timesheetRowLocator));
    }

    public List<TimesheetData> getList(){
        List<TimesheetData> timesheets = new ArrayList<>();
        getTimesheets().forEach((m) -> timesheets.add(getTimesheetFromTimesheetRow(m)));
        return timesheets;
    }

    private TimesheetData getTimesheetFromTimesheetRow(WebElement timesheetRow) {
        return new TimesheetData().withUserFullName(timesheetRow.findElement(By.cssSelector(" .grid__col-index_0")).getText());
    }
}
