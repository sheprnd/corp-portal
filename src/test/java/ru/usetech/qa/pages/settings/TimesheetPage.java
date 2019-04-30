package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TimesheetPage extends Page {

    public TimesheetPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = "icon-tooltip")
    private WebElement icon;

    @FindBy(css = "[formcontrolname='work_to']")
    private WebElement dropdownWorkTo;

    @FindBy(css = "users-dropdown[formcontrolname='user']")
    private WebElement dropdownUser;

    @FindBy(css = ".ui-dropdown-items > li:nth-child(2)")
    private WebElement elementUser;

    @FindBy(css = ".ui-dropdown-items")
    private WebElement timeList;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    @FindBy(css = ".default-shedule")
    private WebElement defaultShedule;

    @FindBy(css = ".ui-chkbox-icon")
    private WebElement checkBox;

    @FindBy(css = "div.default-shedule .grid-im__item.table-h__item-row.grid__col-index_1")
    private WebElement defaulSheduleCell;

    private void initTimesheetCreation() {
        click(addButton);
        wait.until(visibilityOf(icon));
    }

    private void fillTimesheetForm() {

        click(dropdownUser);
        click(elementUser);
    }

    private void saveTimesheet() {
        click(saveButton);
    }

    public void create() {
        wait.until(visibilityOf(defaulSheduleCell));

        initTimesheetCreation();
        fillTimesheetForm();
        click(checkBox);
        saveTimesheet();

    }

    private void openDefaultShedule() {
        click(defaultShedule);
        wait.until(visibilityOf(dropdownWorkTo));
    }

    public void editDefaultTimesheet(int dayIndex, int timeAt, int timeTo) {

        openDefaultShedule();
        editDay(dayIndex, timeAt, timeTo);
        saveTimesheet();

    }

    private void editDay(int dayIndex, int timeAt, int timeTo) {

        WebElement day = getDayByIndex(dayIndex);
        editDayCheckbox(day);

        if (timeTo >=0 & timeAt >=0) {

            // выбрать время начала
            selectTime(day, "work_at", timeAt);
            // выбрать время окончания
            selectTime(day, "work_to", timeTo);

       }
    }

    private void editDayCheckbox(WebElement day) {
        WebElement dayCheckbox = day.findElement(By.cssSelector(".ui-chkbox-box"));
        click(dayCheckbox);
    }

    private WebElement getDayByIndex(int dayIndex) {
        return driver.findElement(By.cssSelector(".modal-settings .modal-settings__item:nth-child(" + (dayIndex + 2) +")"));
    }

    // пока сделано, что можно выбрать только целый час
    // потом можно доделать, чтобы можно было выбирать и часы с минутами
    private void selectTime(WebElement day, String workType, int time) {

        int index = 0;

        // индекс для выбора времени в списке
        if (workType.equals("work_at")) {
            index = time * 2 + 1;
        } else {
            index = time * 2;
        }

        // раскрыть список
        WebElement list = day.findElement(By.cssSelector("[formcontrolname=" + workType + "]"));
        click(list);

        // выбрать время
        WebElement element = driver.findElement(By.cssSelector(".ui-dropdown-items .ui-dropdown-item:nth-child(" + index + ")"));
        click(element);
    }


}

