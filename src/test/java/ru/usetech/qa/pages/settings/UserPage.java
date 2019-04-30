package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.UserData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

// страница списка пользователей и форма пользователя

public class UserPage extends Page {

    public UserPage(WebDriver driver){
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

    @FindBy(css = ".modal-header__close")
    private WebElement closeUserButton;

    @FindBy(css = ".post__avatar")
    private WebElement avatar;

    private void initUserCreation(){
        click(addUserButton);
        wait.until(visibilityOf(userForm));
    }


    private void fillUserForm(UserData userData) {

        type(lastName, userData.getLastName());
        type(firstName, userData.getFirstName());
        type(email, userData.getEmail());
        type(password, userData.getPassword());
        type(confirmPassword, userData.getPassword());

    }

    private void saveUser(){
        click(saveUserButton);
    }

    public void create(UserData userData){
        initUserCreation();
        fillUserForm(userData);
        saveUser();
    }


    public void edit(int userIndex, UserData userData, String text) {
        openUser(userIndex);
        type(firstName, userData.getFirstName() + "_" + text);
        saveUser();
    }

    private void openUser(int index) {
        WebElement user = driver.findElement(By.cssSelector(".users .ng-star-inserted:nth-child(" + index + ") .grid-im"));
        click(user);
        wait.until(visibilityOf(userForm));
    }

    private void closeUser() {
        click(closeUserButton);
        //wait.until(visibilityOf(userForm));
    }

    public UserData getUser(int index) {
        openUser(index);
        UserData user = new UserData().withFirstName(firstName.getAttribute("value")).withEmail(email.getAttribute("value"));
        closeUser();
        return user;
    }


}
