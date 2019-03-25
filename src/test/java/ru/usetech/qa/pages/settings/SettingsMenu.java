package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.pages.Page;

// страница с меню разделов настроек (Пользователи, Отделы, Роли и т.д)

public class SettingsMenu extends Page{

    public SettingsMenu(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[href = '#/settings/users']")
    private WebElement usersListLink;

    @FindBy(css = "[href = '#/settings/groups']")
    private WebElement rolesListLink;

    @FindBy(css = "[href = '#/settings/departments']")
    private WebElement departmentsListLink;

    @FindBy(css = "[href = '#/settings/satisfaction-templates']")
    private WebElement feedbackTemplateListLink;

    @FindBy(css = "[href = '#/settings/priority']")
    private WebElement prioritiesListLink;

    @FindBy(css = "[href = '#/settings/incidents-categories']")
    private WebElement categoriesListLink;

    @FindBy(css = "[href = '#/settings/reports']")
    private WebElement reportsListLink;

    @FindBy(css = "[href = '#/settings/report-groups']")
    private WebElement reportGroupsLink;

    @FindBy(css = "[href = '#/settings/workflow']")
    private WebElement workflowLink;

    @FindBy(css = ".settings-pipe")
    private WebElement stage;

    public void goToUsers() {
        click(usersListLink);
    }

    public void goToRoles() {
        click(rolesListLink);
    }

    public void goToDepartments() { click(departmentsListLink); }

    public void goToFeedbacktemplates() { click(feedbackTemplateListLink); }

    public void goToWorkflow() {
        click(workflowLink);
        wait.until(ExpectedConditions.visibilityOf(stage));
    }

    public void goToPriorities(){
        click(prioritiesListLink);
    }

    public void goToCategories(){
        click(categoriesListLink);
    }

    public void goToReports(){
        click(reportsListLink);
    }

    public void goToReportGroups(){
        click(reportGroupsLink);
    }
}
