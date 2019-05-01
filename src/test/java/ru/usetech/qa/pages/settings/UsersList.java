package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.UserData;
import ru.usetech.qa.pages.Page;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class UsersList extends Page {

    public UsersList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".users > div:first-child .post__avatar")
    private WebElement firstRow;

    public int count() {

        wait.until(visibilityOf(firstRow));
        return getElementsCount(".users .grid-im__wrap");

    }

    public void waitListUpdated(int count) {
        wait.until(numberOfElementsToBeMoreThan(By.cssSelector(".users .grid-im__wrap"), count));
    }

    private String getEmail(int index) {
        return driver.findElement(By.cssSelector(".users .ng-star-inserted:nth-child(" + index + ") .grid__col-index_1")).getText();
    }

    public String getUserFullNameByEmail(String email) {

        List<WebElement> users = driver.findElements(By.cssSelector(".users .ng-star-inserted"));

        return users.stream().filter(m -> m.findElement(By.cssSelector(".grid__col-index_1")).
                getText().equals(email)).findFirst().get().findElement(By.cssSelector(".grid__col-index_0")).getText();

    }

    public UserData getUser(int index) {
        return new UserData().withEmail(getEmail(index));
    }
}
