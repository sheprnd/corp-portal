package ru.usetech.qa.pages.modalDialogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddDeleteReasonDialog {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AddDeleteReasonDialog(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "add-remove-reason-modal button:first-child")
    private WebElement saveDeleteReasonButton;

    public void setupReason() {
        saveDeleteReasonButton.click();
    }
}
