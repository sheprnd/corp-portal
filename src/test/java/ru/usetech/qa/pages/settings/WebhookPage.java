package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.WebhookData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebhookPage extends Page {

    public WebhookPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[formcontrolname=name]")
    private WebElement name;

    @FindBy(css = "input[formcontrolname=url]")
    private WebElement url;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initWebhookCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillWebhookForm(WebhookData webhookData) {

        type(name, webhookData.getWebhookName());
        type(url, webhookData.getWebhookUrl());
    }

    private void saveWebhook() {
        click(saveButton);
    }

    public void create(WebhookData webhookData) {
        initWebhookCreation();
        fillWebhookForm(webhookData);
        saveWebhook();

    }
}
