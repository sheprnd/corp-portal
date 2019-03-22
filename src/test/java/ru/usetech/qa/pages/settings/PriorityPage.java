package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.model.PriorityData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PriorityPage extends Page {

    public PriorityPage(WebDriver driver){
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

//    @FindBy(css = "h3.content__title.mar-l-0")
//    private WebElement pageTitle;


    private void initPriorityCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillPriorityForm(PriorityData priorityData) {

        type(name, priorityData.getPriorityName());
    }

    private void savePriority() {
        click(saveButton);
    }

    public void create(PriorityData priorityData) {
        initPriorityCreation();
        fillPriorityForm(priorityData);
        savePriority();

    }
}
