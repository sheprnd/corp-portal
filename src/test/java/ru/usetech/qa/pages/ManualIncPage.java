package ru.usetech.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.model.ManIncData;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

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
    private WebElement postUrl;

    @FindBy(css = "[formcontrolname=newPostText]")
    private WebElement postText;

    @FindBy(css = ".modal-dialog")
    private WebElement modalDialog;

    @FindBy(css = ".alert-success ")
    private WebElement alertSuccess;

    @FindBy(css = ".ng-star-inserted[text='Ошибка содания инцидента']")
    private WebElement alertNotSuccess;

    public void add() {

        click(createBtn);
        wait.until(stalenessOf(driver.findElement(By.cssSelector(".load__wrap"))));
        //wait.until(visibilityOf(modalDialog));

    }

    public void fill(ManIncData manIncData) {

        type(postUrl, manIncData.getPostUrlField());
        type(postText, manIncData.getPostText());
    }

    public void save() {

        click(saveBtn);
    }

    public void isManIncPageClosed() {
        wait.until(ExpectedConditions.visibilityOf(modalDialog));
    }

    public boolean alertSuccess() {

      return isElementPresent(alertSuccess);

    }

    public void alertNotSuccess() {
        wait.until(ExpectedConditions.visibilityOf(alertNotSuccess));
    }


}





