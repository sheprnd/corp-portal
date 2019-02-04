package ru.usetech.qa.pages.settings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Posts list page

public class PostsPage extends Page {

    public PostsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addRoleButton;

    @FindBy(css = "div.post")
    private WebElement postAtPostsLists;

    @FindBy(css = ".alert-success ")
    private WebElement alertSuccess;

    @FindBy(xpath = "//post[1]/div/div/div[3]/div[2]/div/button[3]")
    private WebElement deleteButton;

    @FindBy(xpath = "//post[1]/div/div/div[3]/div[2]/div/button[1]")
    private WebElement moveToSelected;

    @FindBy(xpath = "//add-remove-reason-modal/div[4]/button[1]")
    private WebElement saveDeleteReason;




    public void scrollPage() {

        wait.until(visibilityOf(postAtPostsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public void alertSuccess() {
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));
    }


    public void moveToSelected() {

        click(moveToSelected);
        alertSuccess();

    }

    public void moveToDeleted() {

        click(deleteButton);
        click(saveDeleteReason);
        alertSuccess();
    }
}
