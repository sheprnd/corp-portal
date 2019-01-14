package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

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

    public void addNewUser(){
        addUserButton.click();
        wait.until(visibilityOf(userForm));
    }
}
