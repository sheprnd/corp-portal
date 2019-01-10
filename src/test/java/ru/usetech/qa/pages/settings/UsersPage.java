package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

public class UsersPage extends Page {

    public UsersPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
