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

    @FindBy(xpath = "//app-incidents-settings-list/div/div/div")
    private WebElement addButton;

    @FindBy(css = ".modal")
    private WebElement modalForm;

    @FindBy(css = "[formcontrolname='title']")
    private WebElement title;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    @FindBy(xpath = "//app-incidents-settings-list/settings-users-references-list/div/ul/li[1]/a/div/i")
    private WebElement pencil;

    @FindBy(css = "div.filtr__value:contains('Тестовый справочник Selenium')")
    private WebElement readyReferenceLink;

    @FindBy(xpath = "//button[contains(text(), 'Удалить')]")
    private WebElement deleteBtn;


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

    public void createAndDelete(ClientReferenceData clientReferenceData) {

        initDepartmentCreation();
        fillForm(clientReferenceData);
        save();

        alertSuccess();

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.cssSelector("div.filtr__value:contains('Тестовый справочник Selenium')"));
        action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector("div.filtr__value:contains('Тестовый справочник Selenium')"))).build().perform();

        //wait.until(ExpectedConditions.visibilityOf(pencil));
        click(pencil);

        wait.until(ExpectedConditions.visibilityOf(modalForm));
        click(deleteBtn);

        alertSuccess();

    }

    public void scrollPage() {

        wait.until(visibilityOf(modalForm));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

}
