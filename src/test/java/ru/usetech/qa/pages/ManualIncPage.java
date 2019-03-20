package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.model.ManIncData;

import static org.testng.Assert.assertTrue;

public class ManualIncPage extends Page {

    public ManualIncPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".btn-big")
    private WebElement createBtn;

    @FindBy(css = "div.modal-footer > button.btn__blue")
    private WebElement saveBtn;

    @FindBy(css = "[formcontrolname=newPostBlogUrl]")
    private WebElement blogUrl;

    @FindBy(css = "[formcontrolname=newPostUrl]")
    private WebElement postUrl;

    @FindBy(css = "[formcontrolname=newPostText]")
    private WebElement postText;

    @FindBy(css = ".modal-dialog")
    private WebElement modalDialog;

    @FindBy(css = ".ng-star-inserted[text='Ошибка содания инцидента']")
    private WebElement alertNotSuccess;

    public boolean add(ManIncData manIncData) {
        //wait.until(ExpectedConditions.elementToBeClickable(createBtn));
        click(createBtn);

        //assertTrue(wait.until(stalenessOf(driver.findElement(By.cssSelector(".load__wrap"))))){
        wait.until(ExpectedConditions.visibilityOf(modalDialog));
        type(blogUrl, manIncData.getPostBlog());
        type(postText, manIncData.getPostText());
        type(postUrl, manIncData.getPostUrlField());
        save();
        return alertSuccess();


    }


    public void save() {
        //wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
        click(saveBtn);
    }

    public void isManIncPageClosed() {

        wait.until(ExpectedConditions.visibilityOf(modalDialog));

    }


    /*public void alertNotSuccess() {
        wait.until(ExpectedConditions.visibilityOf(alertNotSuccess));
    }*/


}





