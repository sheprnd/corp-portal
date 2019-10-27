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

    @FindBy(css = ".post > p")
    private WebElement postId;

    @FindBy(css = "app-post:nth-child(1) > div > div > div.post__right-block > div.post__footer > div > button:nth-child(3)")
    private WebElement deleteButton;

    @FindBy(css = ".wokflow-grid-1 > app-post:first-child  button:first-child")
    private WebElement moveToSelectedButton;

    @FindBy(css = "confirm-modal button.btn__blue")
    private WebElement deleteCurrentButton;


    public void scrollPageDown() {

        wait.until(visibilityOf(postAtPostsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


    public void moveToSelected() {

        click(moveToSelectedButton);

    }

    public void moveToDeleted() {

        wait.until(visibilityOf(deleteButton));
        click(deleteButton);

    }

    public void deleteCurrent() {
        click(deleteCurrentButton);
    }


    public String getId(){

        String ids = postId.getAttribute("innerText");
        String id = ids.substring(9, ids.indexOf(",",9));

        return id;
    }

}
