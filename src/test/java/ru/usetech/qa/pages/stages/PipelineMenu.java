package ru.usetech.qa.pages.stages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

// левое меню с разделами системы (Главный экран, Авторы, Отчеты, Настройки)

public class PipelineMenu extends Page {

    public PipelineMenu(WebDriver driver) {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "i.fa.fa-pencil-square-o")
    private WebElement postsPage;

    @FindBy(css = ".post__right-block")
    private WebElement postspage;

    @FindBy(css = "[href = '#/incidents/stage/3']")
    private WebElement incidentsPage;



    public void goToPosts() { click(postsPage);}

    public void goToIncidents() { click(incidentsPage); }

}
