package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.RoleData;
import ru.usetech.qa.pages.Page;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RolesList extends Page {

    private final String roleRowLocator = ".groups .groups__line";

    public RolesList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".groups > div:first-child .groups__line-th")
    private WebElement firstRow;

    public int count() {

        wait.until(visibilityOf(firstRow));
        return getRoles().size();

    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(roleRowLocator, count, operationType);
    }

    public List<RoleData> getList() {
        List<RoleData> roles = new ArrayList<>();
        getRoles().forEach((m) -> roles.add(getRoleFromRoleRow(m)));
        return roles;
    }

    private RoleData getRoleFromRoleRow(WebElement roleRow) {
        return new RoleData().withName(roleRow.findElement(By.cssSelector(".groups__line-th:first-child")).getText());
    }

    private List<WebElement> getRoles() {
        return driver.findElements(By.cssSelector(roleRowLocator));
    }
}
