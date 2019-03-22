package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.ReportData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ReportPage extends Page {

    public ReportPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[formcontrolname='theme']")
    private WebElement name;

    @FindBy(css = "input[formcontrolname='external_id']")
    private WebElement externalId;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initReportCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillReportForm(ReportData reportData) {

        type(name, reportData.getReportName());
        type(externalId, reportData.getExternalId().toString());
    }

    private void saveReport() {
        click(saveButton);
    }

    public void create(ReportData reportData) {
        initReportCreation();
        fillReportForm(reportData);
        saveReport();

    }
}
