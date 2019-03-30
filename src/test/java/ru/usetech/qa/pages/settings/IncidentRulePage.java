package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class IncidentRulePage extends Page {

    public IncidentRulePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dd-btn")
    private WebElement addButton;

    @FindBy(css = ".dd-btn-list > li:last-child")
    private WebElement incidentRuleButton;

    @FindBy(css = ".modal-settings__numeric")
    private WebElement incidentRuleId;

    @FindBy(css = "[formcontrolname=stage]")
    private WebElement stageMultiselect;

    @FindBy(css = "[formcontrolname=stage] .ui-multiselect-items > .ui-multiselect-item:first-child")
    private WebElement stageElement;

    @FindBy(css = ".modal-settings__item:nth-child(11) .modal-settings__box")
    private WebElement newPostCheckbox;

    @FindBy(css = "[formcontrolname=setStage]")
    private WebElement setStageAction;

    @FindBy(css = "div.ui-dropdown-panel .ui-dropdown-items > li:nth-child(2)")
    private WebElement setStageElement;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initIncidentRuleCreation() {
        click(addButton);
        click(incidentRuleButton);
        wait.until(visibilityOf(incidentRuleId));
    }

    private void fillIncidentRuleForm() {
        click(stageMultiselect);
        click(stageElement);
        click(stageMultiselect);

        click(newPostCheckbox);

        click(setStageAction);
        click(setStageElement);

    }

    private void saveIncidentRule() {
        click(saveButton);
    }

    public void create() {
        initIncidentRuleCreation();
        fillIncidentRuleForm();
        saveIncidentRule();

    }
}
