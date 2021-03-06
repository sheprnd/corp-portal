package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.FeedbackTemplateData;
import ru.usetech.qa.pages.Page;

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

    @FindBy(css = "label.ui-dropdown-label")
    private WebElement dropdown;

    @FindBy(css = ".ui-dropdown-items > li:nth-child(2)")
    private WebElement dropdownElement;

    @FindBy(css = ".modal-settings__closeblock-btn")
    private WebElement addReasonBtn;

    @FindBy(css = "input[formcontrolname='close_reason_text']")
    private WebElement reasonText;

    public void create(FeedbackTemplateData feedbackTemplateData) {

        initFeedbackTemplateCreation();
        fillForm(feedbackTemplateData);
        save();

    }

    private void initFeedbackTemplateCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    private void fillForm(FeedbackTemplateData feedbackTemplateData) {
        type(templateName, feedbackTemplateData.getTemplateName());
        type(templateText, feedbackTemplateData.getTemplateText());
        click(dropdown);
        click(dropdownElement);
        type(reasonText, feedbackTemplateData.getReasonText());
        click(addReasonBtn);

    }


    private void save() {
        click(saveButton);
    }

}
