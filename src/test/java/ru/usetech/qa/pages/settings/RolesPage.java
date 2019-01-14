package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

// страница списка ролей и форма роли

public class RolesPage extends Page{

    public RolesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
