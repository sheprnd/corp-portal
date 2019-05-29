package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.CloseReasonData;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CloseReasonPage extends Page {

    public CloseReasonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[formcontrolname=name]")
    private WebElement name;

    @FindBy(css = "input[formcontrolname=satisfaction]")
    private WebElement satisfaction;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;


    private void initCloseReasonCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillForm(CloseReasonData closeReasonData) {
        type(name, closeReasonData.getName());
        type(satisfaction, closeReasonData.getSatisfaction().toString());
    }

    private void save() {
        click(saveButton);
    }

    public void create(CloseReasonData closeReasonData) {
        initCloseReasonCreation();
        fillForm(closeReasonData);
        save();
    }
}
