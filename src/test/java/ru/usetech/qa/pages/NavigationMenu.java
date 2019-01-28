package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

// левое меню с разделами системы (Главный экран, Авторы, Отчеты, Настройки)

public class NavigationMenu extends Page {

    public NavigationMenu(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href = '#/settings']")
    private WebElement settingsButton;

    @FindBy(css = "settings-menu")
    private WebElement settingsMenu;

    @FindBy(css = "i.fa.fa-pencil-square-o")
    private WebElement postsPage;

    @FindBy(css = ".post__right-block")
    private WebElement postRow;

    public void settings() {

        click(settingsButton);
        wait.until(visibilityOf(settingsMenu));
    }

    public void posts() {

        click(postsPage);
        wait.until(visibilityOf(postRow));
    }


}
