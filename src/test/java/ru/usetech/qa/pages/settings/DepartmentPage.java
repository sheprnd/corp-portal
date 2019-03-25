package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.pages.Page;

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
    private WebElement nameGroup;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    @FindBy(css = "h3.content__title.mar-l-0")
    private WebElement pageTitle;


    private void initDepartmentCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    private void fillForm(DepartmentData departmentData) {

        type(nameGroup, departmentData.getDepartmentName());
    }

    private void save() {
        click(saveButton);
    }

    public void create(DepartmentData departmentData) {

        initDepartmentCreation();
        fillForm(departmentData);
        save();

    }

}
