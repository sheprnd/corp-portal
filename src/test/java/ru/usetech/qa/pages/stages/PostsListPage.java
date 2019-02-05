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

    @FindBy(css = ".content__header .btn")
    private WebElement addRoleButton;

    @FindBy(css = "div.post")
    private WebElement postAtPostsLists;

    @FindBy(xpath = "//post[1]/div/div/div[3]/div[2]/div/button[3]")
    private WebElement deleteButton;

    @FindBy(xpath = "//post[1]/div/div/div[3]/div[2]/div/button[1]")
    private WebElement moveToSelected;

    @FindBy(xpath = "//button[contains(text(), 'Сохранить')]")
    private WebElement saveDeleteReason;

    @FindBy(xpath = "//button[contains(text(), 'Удалить текущий')]")
    private WebElement deleteCurrent;




    public void scrollPage() {

        wait.until(visibilityOf(postAtPostsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


    public void moveToSelected() {

        click(moveToSelected);
        alertSuccess();

    }

    public void moveToDeleted() {

        wait.until(visibilityOf(deleteButton));
        click(deleteButton);
        click(saveDeleteReason);
        alertSuccess();

    }
}
