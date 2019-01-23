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

    @FindBy(css = "users-list")
    private WebElement usersList;

    @FindBy(css = "[href = '#/settings/groups']")
    private WebElement rolesListLink;

    @FindBy(css = "settings-groups-list")
    private WebElement rolesList;

    public void goToUsers() {
        click(usersListLink);
        wait.until(visibilityOf(usersList));
    }


}
