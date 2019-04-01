package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.PostRuleData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PostRulePage extends Page {

    public PostRulePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dd-btn")
    private WebElement addButton;

    @FindBy(css = ".dd-btn-list > li:first-child")
    private WebElement postRuleButton;

    @FindBy(css = ".modal-settings__numeric")
    private WebElement postRuleId;

    @FindBy(css = "[formcontrolname=messageTypes]")
    private WebElement messageTypeMultiselect;

    @FindBy(css = "[formcontrolname=messageTypes] .ui-multiselect-items > li:first-child")
    private WebElement messageTypeElement;

    @FindBy(css = "[formcontrolname=context]")
    private WebElement context;

    @FindBy(css = "[formcontrolname=action]")
    private WebElement actionDropdown;

    @FindBy(css = "div.ui-dropdown-panel .ui-dropdown-items > li:last-child")
    private WebElement actionDelete;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initPostRuleCreation() {
        click(addButton);
        click(postRuleButton);
        wait.until(visibilityOf(postRuleId));
    }

    private void fillPostRuleForm(PostRuleData postRuleData) {
        click(messageTypeMultiselect);
        click(messageTypeElement);
        click(messageTypeMultiselect);
        type(context, postRuleData.getContext());
        click(actionDropdown);
        click(actionDelete);
    }

    private void savePostRule() {
        click(saveButton);
    }

    public void create(PostRuleData rostRuleData) {
        initPostRuleCreation();
        fillPostRuleForm(rostRuleData);
        savePostRule();

    }
}
