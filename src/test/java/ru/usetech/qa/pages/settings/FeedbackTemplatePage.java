package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.usetech.qa.model.FeedbackTemplateData;
import ru.usetech.qa.pages.Page;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Feedback templates list page

public class FeedbackTemplatePage extends Page {

    public FeedbackTemplatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = ".textarea")
    private WebElement templateText;

    @FindBy(css = "input[formcontrolname='name']")
    private WebElement templateName;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    @FindBy(css = "h3.content__title.mar-l-0")
    private WebElement pageTitle;

    @FindBy(css = ".alert-success ")
    private WebElement alertSuccess;

    @FindBy(css = ".ui-dropdown-label")
    private WebElement dropdown;

    @FindBy(css = "div.select__item-custom.select__item-custom_single-child.ng-star-inserted")
    private WebElement dropdownElement;

    @FindBy(css = ".modal-settings__closeblock-btn")
    private WebElement addReasonBtn;

    @FindBy(css = "input[formcontrolname='close_reason_text']")
    private WebElement reasonText;

    /*@FindAll({@FindBy(css = ".select__item-custom_single-child")})
    private List<WebElement> dropdownElements;*/





    public void initFeedbackTemplateCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    public void fillForm(FeedbackTemplateData feedbackTemplateData) {

        type(templateName,feedbackTemplateData.getTemplateName());
        type(templateText,feedbackTemplateData.getTemplateText());
        click(dropdown);
        Select delement = new Select(driver.findElement(By.cssSelector("li.ng-tns-c0-28")));
        delement.selectByIndex(1);
        type(reasonText, feedbackTemplateData.getReasonText());

    }

    public void selectDropdown(WebElement element){

        Select dropdown = new Select(element);
        dropdown.selectByIndex(1);

    }

    public void save() {
        click(saveButton);
    }

    public void create(FeedbackTemplateData feedbackTemplateData) {

        initFeedbackTemplateCreation();
        fillForm(feedbackTemplateData);
        save();
        alertSuccess();

    }


    public void alertSuccess() {
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));
    }


}
