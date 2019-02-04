package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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


    public void goToUsers() {
        click(usersListLink);
    }

    public void goToRoles() {
        click(rolesListLink);
    }

    public void goToDepartments() { click(departmentsListLink); }

    public void goToFeedbacktemplates() { click(feedbackTemplateListLink); }


}
