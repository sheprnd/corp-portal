package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ConnectionLog extends Page {

    public ConnectionLog (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (css=".datepicker__header-input")
    private WebElement datePicker;

    @FindBy(css=".daterangepicker")
    private WebElement daterangepicker;

    @FindBy(css="[name=daterangepicker_start]")
    private WebElement dateStart;

    @FindBy(css="[name=daterangepicker_end]")
    private WebElement dateEnd;

    @FindBy(css=".applyBtn")
    private WebElement applyButton;

    public void filter(String start, String end){
        click(datePicker);
        wait.until(visibilityOf(daterangepicker));
        type(dateStart,start);
        type(dateEnd,end);
        click(applyButton);
    }

    public boolean isNotEmpty() {
        return getConnections().size()>0;
    }

    private List<WebElement> getConnections() {
        return driver.findElements(By.cssSelector(".users .grid-im__wrap"));
    }
}
