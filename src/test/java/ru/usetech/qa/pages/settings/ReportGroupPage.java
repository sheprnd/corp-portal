package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.ReportGroupData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ReportGroupPage extends Page {

    public ReportGroupPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = "label.ui-dropdown-label")
    private WebElement dropdown;

    @FindBy(css = "input[formcontrolname='name']")
    private WebElement name;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initReportGroupCreation() {
        click(addButton);
        wait.until(visibilityOf(dropdown));
    }

    private void fillReportGroupForm(ReportGroupData reportGroupData) {

        type(name, reportGroupData.getReportGroupName());
    }

    private void saveReportGroup() {
        click(saveButton);
    }

    public void create(ReportGroupData reportGroupData) {
        initReportGroupCreation();
        fillReportGroupForm(reportGroupData);
        saveReportGroup();

    }

}
