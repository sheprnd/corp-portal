package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.RoleData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

// Roles list page and role modal page

public class RolesPage extends Page {

    public RolesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addRoleButton;

    @FindBy(css = ".modal-body")
    private WebElement roleForm;

    @FindBy(css = "name=nameGroup")
    private WebElement nameGroup;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveRoleButton;

    @FindBy(css = ".post__avatar")
    private WebElement avatar;


    public void initRoleCreation() {
        click(addRoleButton);
        wait.until(visibilityOf(roleForm));
    }


    public void fillRoleForm(RoleData roleData) {

        type(nameGroup, roleData.getRoleName());


    }

    public void saveRole() {
        click(saveRoleButton);
    }

    public void create(RoleData roleData) {
        initRoleCreation();
        fillRoleForm(roleData);
        saveRole();
    }

    public void scrollPage() {

        wait.until(visibilityOf(avatar));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public int list() {
        scrollPage();
        return driver.findElements(By.cssSelector(".users-list-grid-contained .grid-im")).size();
    }


}
