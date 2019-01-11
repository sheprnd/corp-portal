package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ManualIncPage extends Page {

    public ManualIncPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);

    }
    @FindBy(css=".btn-big")
    private WebElement createBtn;

    @FindBy(css="div.modal-footer > button.btn__blue")
    private WebElement saveBtn;

    @FindBy(css="input.ng-invalid")
    private WebElement postUrlField;

    @FindBy(css=".textarea")
    private WebElement textArea;

    @FindBy(css="label.ng-tns-c0-8")
    private WebElement locationSelector;



}
