package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBeNotEmpty;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Departments list page

public class DepartmentPage extends Page {

    public DepartmentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[formcontrolname='name']")
    private WebElement name;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    @FindBy(css = "h3.content__title.mar-l-0")
    private WebElement pageTitle;


    private void initDepartmentCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    private void fillForm(DepartmentData departmentData) {

        type(name, departmentData.getDepartmentName());
    }

    private void save() {
        click(saveButton);
    }

    public void create(DepartmentData departmentData) {

        initDepartmentCreation();
        fillForm(departmentData);
        save();

    }

    public void edit(int index, DepartmentData department) {

        openDepartment(index);
        wait.until(attributeToBeNotEmpty(name, "value"));
        type(name, department.getDepartmentName());
        save();

    }

    private void openDepartment(int index) {

        WebElement department = driver.findElement(By.cssSelector(".categories div.table__line:nth-child(" + (index + 1) + ")"));
        click(department);
        wait.until(visibilityOf(modalForm));

    }
}
