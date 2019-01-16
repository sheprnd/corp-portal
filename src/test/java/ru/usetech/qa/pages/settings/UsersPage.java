package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

// страница списка пользователей и форма пользователя

public class UsersPage extends Page {

    public UsersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addUserButton;

    @FindBy(css = ".user-form-modal")
    private WebElement userForm;

    @FindBy(css = "[name=lastName]")
    private WebElement lastName;

    @FindBy(css = "[name=firstName]")
    private WebElement firstName;

    @FindBy(css = "[name=email]")
    private WebElement email;

    @FindBy(css = "[name=pass1]")
    private WebElement password;

    @FindBy(css = "[name=pass2]")
    private WebElement confirmPassword;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveUserButton;

    public void addNewUser(){
        addUserButton.click();
        wait.until(visibilityOf(userForm));
    }

    public void fillTheField(WebElement field, String text) {
        field.clear();
        field.sendKeys(text);
    }

    public void fillUserForm(String lastNameText,  String firstNameText, String emailText, String passwordText) {

        fillTheField(lastName, lastNameText);
        fillTheField(firstName, firstNameText);
        fillTheField(email, emailText);
        fillTheField(password, passwordText);
        fillTheField(confirmPassword, passwordText);

    }

    public void saveUser(){
        wait.until(elementToBeClickable(saveUserButton));
        saveUserButton.click();
    }

    public void scrollPage(){

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public int usersCount() {
        scrollPage();
        return driver.findElements(By.cssSelector(".users-list-grid-contained .grid-im")).size();
    }


}
