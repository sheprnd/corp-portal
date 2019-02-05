package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.model.RoleData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Departments list page

public class DepartmentsPage extends Page {

    public DepartmentsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[formcontrolname='name']")
    private WebElement nameGroup;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    @FindBy(css = "h3.content__title.mar-l-0")
    private WebElement pageTitle;


    public void initDepartmentCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    public void fillForm(DepartmentData departmentData) {

        type(nameGroup, departmentData.getDepartmentName());
    }

    public void save() {
        click(saveButton);
    }

    public void create(DepartmentData departmentData) {

        initDepartmentCreation();
        fillForm(departmentData);
        save();

    }

    public void scrollPage() {

        wait.until(visibilityOf(pageTitle));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

}
