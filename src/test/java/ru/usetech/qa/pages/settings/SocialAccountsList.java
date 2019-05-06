package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SocialAccountsList extends Page {

    public SocialAccountsList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".social div.social__line:nth-child(2)")
    private WebElement firstAccountRow;

    @FindBy(css =".social__group:first-child")
    private WebElement firstGroupRow;

    @FindBy(css="confirm-modal .btn__blue")
    private WebElement confirmButton;

    public void waitListUpdated(int count, int operationType) {

        waitListUpdated(".social div.social__line", count, operationType);
    }

    public int countAccounts() {

        wait.until(visibilityOf(firstAccountRow));
        return getElementsCount(".social div.social__line");

    }

    private List<WebElement> getSocialAccounts(String socialType) {

        List<WebElement> accounts = driver.findElements(By.cssSelector(".social div.social__line"));

        return accounts.stream().filter(m -> m.findElement(By.cssSelector(".social__line-th:nth-child(1) > .social__header-title")).
                getText().equals(socialType)).collect(Collectors.toList());

    }

    private WebElement getSocialAccount(String socialType, String accountName) {

        return getSocialAccounts(socialType).stream().filter(m -> m.findElement(By.cssSelector(".social__line-th:nth-child(2)")).
                getText().equals(accountName)).findFirst().get();

    }

    public int countCroups(String socialType, String accountName) {

        WebElement groupsDropdown = getSocialAccount(socialType, accountName).findElement(By.cssSelector(".social__line-th:first-child .social__line-open"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+(groupsDropdown.getLocation().getY()-700)+");");

        click(groupsDropdown);
        wait.until(visibilityOf(firstGroupRow));
        return driver.findElements(By.cssSelector(".social__group")).size();

    }


    public boolean socialAccountExists(String socialType, String accountName) {

        wait.until(visibilityOf(firstAccountRow));

        return getSocialAccounts(socialType).stream().anyMatch((m) -> m.findElement(By.cssSelector(".social__line-th:nth-child(2)")).
                getText().equals(accountName));

    }

    public void deleteSocialAccount(String socialType, String accountName) {

        WebElement buttonDelete = getSocialAccount(socialType, accountName).findElement(By.cssSelector(".social__line-th:nth-child(4) .btn__close"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+(buttonDelete.getLocation().getY()-700)+");");

        click(buttonDelete);
        wait.until(visibilityOf(confirmButton));
        click(confirmButton);

    }
}

