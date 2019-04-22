package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TimesheetPage extends Page {

    public TimesheetPage(WebDriver driver){
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
        initTimesheetCreation();
        fillTimesheetForm();
        saveTimesheet();

    }

    public void edit() {
        openDefaultShedule();
        click(saveButton);

    }

    private void openDefaultShedule() {
        click(defaultShedule);
        wait.until(visibilityOf(dropdownWorkTo));
    }
}
