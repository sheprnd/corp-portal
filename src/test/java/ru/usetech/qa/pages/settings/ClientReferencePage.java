package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.model.ClientReferenceData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Client reference list page

public class ClientReferencePage extends Page {

    public ClientReferencePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "app-incidents-settings-list .fa-plus")
    private WebElement addButton;

    @FindBy(css = ".modal")
    private WebElement modalForm;

    @FindBy(css = "[formcontrolname='title']")
    private WebElement title;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

//    @FindBy(xpath = "//app-incidents-settings-list/settings-users-references-list/div/ul/li[1]/a/div/i")
//    private WebElement pencil;

//    @FindBy(css = "//settings-users-references-list/div//span[contains(text(), '01_Тестовый справочник Selenium')]")
//    private WebElement readyReferenceLink;

    @FindBy(css = "settings-users-references-modal button:nth-child(2)")
    private WebElement deleteBtn;

    @FindBy(css = "confirm-modal")
    private WebElement confirmationModal;

    @FindBy(css = "confirm-modal button:first-child")
    private WebElement confirmDeletionBtn;

    public void initDepartmentCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }


    public void fillForm(ClientReferenceData clientReferenceData) {

        type(title, clientReferenceData.getreferenceName());
    }

    public void save() {
        click(saveButton);
    }

    public void create(ClientReferenceData clientReferenceData) throws InterruptedException {

        initDepartmentCreation();
        fillForm(clientReferenceData);
        save();

    }

    public void delete(int index) throws InterruptedException {

        String linkLocator = "settings-users-references-list li:nth-child(" + (index + 1) +")";
        String pencilLocator = "settings-users-references-list li:nth-child(" + (index + 1) +") .fa-pencil";

        scrollPage();
        WebElement referenceLink = driver.findElement(By.cssSelector(linkLocator));

        Actions action = new Actions(driver);
        action.moveToElement(referenceLink).build().perform();

        WebElement pencil = driver.findElement(By.cssSelector(pencilLocator));
        wait.until(ExpectedConditions.visibilityOf(pencil));

        click(pencil);
        wait.until(ExpectedConditions.visibilityOf(modalForm));

        click(deleteBtn);
        wait.until(ExpectedConditions.visibilityOf(confirmationModal));

        click(confirmDeletionBtn);

    }

    public void scrollPage() {

        wait.until(visibilityOf(addButton));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

}
