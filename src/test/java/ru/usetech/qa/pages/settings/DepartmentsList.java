package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.DepartmentData;
import ru.usetech.qa.pages.Page;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DepartmentsList extends Page {

    public DepartmentsList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".categories div.table__line")
    private WebElement firstRow;

    public int count() {
        wait.until(visibilityOf(firstRow));
        return getElementsCount(".categories div.table__line");
    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(".categories div.table__line", count, operationType);
    }

    public List<DepartmentData> getList(){
        scrollPageDown();
        List<DepartmentData> departments = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.cssSelector(".categories div.table__line"));
        for (WebElement element:elements) {
            DepartmentData department = new DepartmentData().withName(element.getText());
            departments.add(department);
        }
        return departments;
    }

    public void delete(int index) {
        WebElement deleteButton = driver.findElement(By.cssSelector(".categories div.table__line:nth-child(" + (index + 1) + ") .btn__close"));
        click(deleteButton);

    }
}
