package ru.usetech.qa.pages.stages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Incidents list page

public class IncidentsListPage extends Page {

    public IncidentsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".post-incident-table")
    private WebElement incidentAtIncidentsLists;

    @FindBy(css = ".wokflow-grid-3 > incident:first-child .post__buttons > button:last-child")
    private WebElement deleteIncFromListBtn;

    /*@FindBy(css = "add-remove-reason-modal button:first-child")
    private WebElement saveDeleteReason;*/

    @FindBy(css = "confirm-modal button.btn__blue")
    private WebElement confirmIncDeletionBtn;

    @FindBy(css = ".incident-form-modal__authors-item-img")
    private WebElement authorsImg;

    @FindBy(css = ".modal-footer > button:nth-child(4)")
    private WebElement deleteIncModal;

    @FindBy(css ="#send")
    private WebElement moveToOtherStageTab;

    @FindBy(css = "dropdown-button")
    private WebElement moveDropdownButton;

    @FindBy(css = "dropdown-button .dd-btn-list > li:first-child")
    private WebElement stageAtDropdownMenu;

/*    @FindBy(css = "input.header__search-field")
    private WebElement searchField;

    @FindBy(css = "button.header__search-btn > .fa-search")
    private WebElement searchBtn;

    @FindBy(css = "[formcontrolname='responseText']")
    private WebElement answerText;

    @FindBy(css = "li.dd-btn-item:last-child")
    private WebElement withoutMovementStage;

    @FindBy(css = "div.modal-footer > button.btn.btn-left.btn__blue:first-child")
    private WebElement confirmButton;

    @FindBy(xpath = "//select-acc-for-publish-modal//p-dropdown/div/label")
    private WebElement selectAccountDrpDown;

    @FindBy(xpath = "//span[contains(text(), 'Usetech Test 2')]")
    private WebElement okAccPreSelected;

    @FindBy(css = "div.modal-header__close.ng-star-inserted > i")
    private WebElement closeModalBtn;*/





    public void scrollPage() {

        wait.until(visibilityOf(incidentAtIncidentsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public void deleteIncident(boolean fromList) {

        if (fromList) {
            click(deleteIncFromListBtn);
        }
        else {
            click(deleteIncModal);
        }

       click(confirmIncDeletionBtn);
    }

    public void openIncident() {

        click(incidentAtIncidentsLists);
        wait.until(ExpectedConditions.visibilityOf(authorsImg));
     }


    public void moveIncident() {

        click(moveToOtherStageTab);
        wait.until(ExpectedConditions.visibilityOf(moveDropdownButton));
        click(moveDropdownButton);
        click(stageAtDropdownMenu);

    }

    /*public void setupDeleteReason() {
        click(saveDeleteReason);
    }*/

/*
    public void publishToOk() {

        click(searchField);
        type(searchField, "Пост для проверки таймаута");
        wait.until(ExpectedConditions.visibilityOf(searchBtn));
        click(searchBtn);
        click(incidentAtIncidentsLists);
        click(answerText);
        type(answerText, "Ответ " + new Random().nextInt(10000));
        wait.until(ExpectedConditions.visibilityOf(moveDropdownButton));
        click(moveDropdownButton);
        click(withoutMovementStage);
        click(confirmButton);
        click(selectAccountDrpDown);
        click(okAccPreSelected);
        click(confirmButton);
        alertSuccess();
        click(closeModalBtn);
    }
*/



}
