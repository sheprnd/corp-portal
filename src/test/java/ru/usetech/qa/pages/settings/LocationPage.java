package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.LocationData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LocationPage extends Page {

    public LocationPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[name=name]")
    private WebElement name;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initLocationCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillLocationForm(LocationData locationData) {

        type(name, locationData.getLocationName());
    }

    private void saveLocation() {
        click(saveButton);
    }

    public void create(LocationData locationData) {
        initLocationCreation();
        fillLocationForm(locationData);
        saveLocation();

    }
}
