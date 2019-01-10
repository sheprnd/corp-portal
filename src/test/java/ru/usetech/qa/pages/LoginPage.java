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
public class LoginPage extends Page {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);

    }
    
  @FindBy(name = "login")
  private WebElement login;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(css=".btn")
  private WebElement submit;

}
