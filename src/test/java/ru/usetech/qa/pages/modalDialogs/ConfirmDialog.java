package ru.usetech.qa.pages.modalDialogs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ConfirmDialog {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ConfirmDialog(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "confirm-modal")
    private WebElement confirmModal;

    @FindBy(css = "confirm-modal .btn__blue")
    private WebElement confirmButton;

    public void confirm(){
        wait.until(visibilityOf(confirmModal));
        wait.until(elementToBeClickable(confirmButton));
        confirmButton.click();
    }

}
