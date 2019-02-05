package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(css = "h3.content__title.mar-l-0")
    private WebElement pageTitle;

    @FindBy(xpath = "//references-dropdown/p-dropdown/div/label")
    private WebElement dropdown;

    @FindBy(xpath = "/html/body/div/div[2]/ul/li[2]/div")
    private WebElement dropdownElement;

    @FindBy(css = ".modal-settings__closeblock-btn")
    private WebElement addReasonBtn;

    @FindBy(css = "input[formcontrolname='close_reason_text']")
    private WebElement reasonText;

    public void create(FeedbackTemplateData feedbackTemplateData) {

        initFeedbackTemplateCreation();
        fillForm(feedbackTemplateData);
        save();
        alertSuccess();

    }

    public void initFeedbackTemplateCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    public void fillForm(FeedbackTemplateData feedbackTemplateData) {
        type(templateName, feedbackTemplateData.getTemplateName());
        type(templateText, feedbackTemplateData.getTemplateText());
        click(dropdown);
        click(dropdownElement);
        type(reasonText, feedbackTemplateData.getReasonText());
        click(addReasonBtn);


    }


    public void save() {
        click(saveButton);
    }

}
