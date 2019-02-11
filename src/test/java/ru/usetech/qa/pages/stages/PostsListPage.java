package ru.usetech.qa.pages.stages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Posts list page

public class PostsListPage extends Page {

    public PostsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".post")
    private WebElement postAtPostsLists;

    @FindBy(css = ".wokflow-grid-1 > post:first-child .post__buttons > button:last-child")
    private WebElement deleteButton;

    @FindBy(css = ".wokflow-grid-1 > post:first-child .post__buttons > button:first-child")
    private WebElement moveToSelected;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить')]")
    private WebElement saveDeleteReason;

    @FindBy(xpath = "//button[contains(text(), 'Удалить текущий')]")
    private WebElement deleteCurrent;

    @FindBy(css = "div.filtr__value:contains('Тестовый справочник')")
    private WebElement createdReferenceLink;





    public void scrollPage() {

        wait.until(visibilityOf(postAtPostsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


    public void moveToSelected() {

        click(moveToSelected);

    }

    public void moveToDeleted() {

        wait.until(visibilityOf(deleteButton));
        click(deleteButton);
        click(saveDeleteReason);

    }
}
