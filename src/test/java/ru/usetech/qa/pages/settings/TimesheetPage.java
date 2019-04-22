package ru.usetech.qa.pages.settings;

import org.junit.Assert;
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


    public boolean edit() {

        wait.until(visibilityOf(defaulSheduleCell));
        String before = defaulSheduleCell.getText().toString();
        String after = "";

        openDefaultShedule();
        click(checkBox);
        click(saveButton);

        if (before.equals("-")) {
            after = "09:00 — 18:59";
        } else if (!"-".equals(before)) {
            after = "-";
        }

        if (!after.equals(before)) {
            return true;

        } else return false;


    }

    private void openDefaultShedule() {
        click(defaultShedule);
        wait.until(visibilityOf(dropdownWorkTo));
    }
}

