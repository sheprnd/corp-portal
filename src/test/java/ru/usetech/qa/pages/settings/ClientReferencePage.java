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

    @FindBy(xpath = "//settings-users-references-list/div//span[contains(text(), '01_Тестовый справочник Selenium')]")
    private WebElement readyReferenceLink;

    @FindBy(xpath = "//button[contains(text(), 'Удалить')]")
    private WebElement deleteBtn;

    @FindBy(xpath = "//confirm-modal/div[contains(text(), 'Вы действительно хотите удалить справочник?')]")
    private WebElement confirmationModal;

    @FindBy(xpath = "//confirm-modal//button[contains(text(), 'Удалить')]")
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

    public void delete(ClientReferenceData clientReferenceData) throws InterruptedException {


        scrollPage();
        click(readyReferenceLink);

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.
                xpath("//settings-users-references-list/div//span[contains(text(), " +
                        "'01_Тестовый справочник Selenium')]"));

        action.moveToElement(we).moveToElement(driver.
                findElement(By.xpath("//settings-users-references-list/div//span[contains(text()," +
                        " '01_Тестовый справочник Selenium')]")))
                .build().perform();
        Thread.sleep(2000);


        //wait.until(ExpectedConditions.visibilityOf(pencil));
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
