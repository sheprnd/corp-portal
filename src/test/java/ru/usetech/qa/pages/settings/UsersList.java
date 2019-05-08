package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.UserData;
import ru.usetech.qa.pages.Page;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class UsersList extends Page {

    private final String emailLocator = ".grid__col-index_1";
    private final String userRowLocator = ".users .grid-im__wrap";

    public UsersList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".users > div:first-child .post__avatar")
    private WebElement firstRow;

    public int count() {
        wait.until(visibilityOf(firstRow));
        return getUsers().size();
    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(userRowLocator, count, operationType);
    }

    private String getEmailByUserRowIndex(int index) {
        return driver.findElement(By.cssSelector(".users > div:nth-child(" + index + ") " + emailLocator)).getText();
    }

    private List<WebElement> getUsers(){
        return driver.findElements(By.cssSelector(userRowLocator));
    }

    public UserData getUserByIndex(int index) {
        return new UserData().withEmail(getEmailByUserRowIndex(index));
    }

    private UserData getUserFromUserRow(WebElement userRow) {
        return new UserData().withEmail(userRow.findElement(By.cssSelector(emailLocator)).getText());
    }

    private WebElement getUserRowByEmail(String email) {
        return getUsers().stream().filter(m -> m.findElement(By.cssSelector(emailLocator)).
                getText().equals(email)).findFirst().get();
    }

    public String getUserFullNameByEmail(String email) {
        return getUserRowByEmail(email).findElement(By.cssSelector(".grid__col-index_0")).getText();
    }

    public void delete(UserData user) {
        WebElement deleteButton = getUserRowByEmail(user.getEmail()).findElement(By.cssSelector(".btn__close"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+(deleteButton.getLocation().getY()-700)+");");
        click(deleteButton);
    }

    public List<UserData> getList() {
        List<UserData> users = new ArrayList<>();
        getUsers().forEach((m) -> users.add(getUserFromUserRow(m)));
        return users;
    }



}
