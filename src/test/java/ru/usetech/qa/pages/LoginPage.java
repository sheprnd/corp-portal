package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
