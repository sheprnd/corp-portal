package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

// страница с меню разделов настроек (Пользователи, Отделы, Роли и т.д)

public class SettingsMenu extends Page{

    public SettingsMenu(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[href = '#/settings/users']")
    private WebElement usersListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Пользователи')]")
    private WebElement usersBlock;

    @FindBy(css = "[href = '#/settings/departments']")
    private WebElement departmentsListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Отделы')]")
    private WebElement departmentsBlock;;

    @FindBy(css = "[href = '#/settings/groups']")
    private WebElement rolesListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Роли')]")
    private WebElement rolesBlock;

    @FindBy(css = "[href = '#/settings/timesheet']")
    private WebElement timesheetsListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Расписание')]")
    private WebElement timesheetsBlock;

    @FindBy(css = "[href = '#/settings/satisfaction-templates']")
    private WebElement feedbackTemplatesListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Шаблоны опросов')]")
    private WebElement feedbackTemplatesBlock;

    @FindBy(css = "[href = '#/settings/social']")
    private WebElement socialsListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Социальные сети')]")
    private WebElement socialsBlock;

    @FindBy(css = "[href = '#/settings/hooks']")
    private WebElement webhooksListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Веб-хуки')]")
    private WebElement webhooksBlock;

    @FindBy(css = "[href = '#/settings/rules']")
    private WebElement rulesListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Правила')]")
    private WebElement rulesBlock;

    @FindBy(css = "[href = '#/settings/priority']")
    private WebElement prioritiesListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Важность')]")
    private WebElement prioritiesBlock;

    @FindBy(css = "[href = '#/settings/incidents-categories']")
    private WebElement categoriesListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Категории инцидентов')]")
    private WebElement categoriesBlock;

    @FindBy(css = "[href = '#/settings/reports']")
    private WebElement reportsListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Темы')]")
    private WebElement reportsBlock;

    @FindBy(css = "[href = '#/settings/report-groups']")
    private WebElement reportGroupsListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Группы тем')]")
    private WebElement reportGroupsBlock;

    @FindBy(css = "[href = '#/settings/location']")
    private WebElement locationsListLink;

    @FindBy(xpath = "//h3[contains(text(), 'Локации')]")
    private WebElement locationsBlock;

    @FindBy(css = "[href = '#/settings/workflow']")
    private WebElement workflowLink;

    @FindBy(css = ".settings-pipe")
    private WebElement stage;

    public void goToUsers() {
        click(usersListLink);
        wait.until(visibilityOf(usersBlock));
    }

    public void goToDepartments() {
        click(departmentsListLink);
        wait.until(visibilityOf(departmentsBlock));
    }

    public void goToRoles() {
        click(rolesListLink);
        wait.until(visibilityOf(rolesBlock));
    }

    public void goToTimesheets() {
        click(timesheetsListLink);
        wait.until(visibilityOf(timesheetsBlock));
    }

    public void goToFeedbacktemplates() {
        click(feedbackTemplatesListLink);
        wait.until(visibilityOf(feedbackTemplatesBlock));
    }

    public void goToSocialAccounts() {
        click(socialsListLink);
        wait.until(visibilityOf(socialsBlock));
    }

    public void goToWebhooks() {
        click(webhooksListLink);
        wait.until(visibilityOf(webhooksBlock));
    }

    public void goToRules() {
        click(rulesListLink);
        wait.until(visibilityOf(rulesBlock));
    }

    public void goToWorkflow() {
        click(workflowLink);
        wait.until(visibilityOf(stage));
    }

    public void goToPriorities(){
        click(prioritiesListLink);
        wait.until(visibilityOf(prioritiesBlock));
    }

    public void goToCategories(){
        click(categoriesListLink);
        wait.until(visibilityOf(categoriesBlock));
    }

    public void goToReports(){
        click(reportsListLink);
        wait.until(visibilityOf(reportsBlock));
    }

    public void goToReportGroups(){
        click(reportGroupsListLink);
        wait.until(visibilityOf(reportGroupsBlock));
    }

    public void goToLocations(){
        click(locationsListLink);
        wait.until(visibilityOf(locationsBlock));
    }

}
