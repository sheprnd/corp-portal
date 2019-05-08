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

    private final String departmentRowLocator = ".categories div.table__line";

    public DepartmentsList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = departmentRowLocator)
    private WebElement firstRow;

    public int count() {
        wait.until(visibilityOf(firstRow));
        return getDepartments().size();
    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(departmentRowLocator, count, operationType);
    }

    private List<WebElement> getDepartments(){
        return driver.findElements(By.cssSelector(departmentRowLocator));
    }

    private DepartmentData getDepartmentFromDepartmentRow(WebElement departmentRow) {
        return new DepartmentData().withName(departmentRow.getText());
    }

    public List<DepartmentData> getList(){
        List<DepartmentData> departments = new ArrayList<>();
        getDepartments().forEach((m) -> departments.add(getDepartmentFromDepartmentRow(m)));
        return departments;
    }

    public void delete(int index) {
        WebElement deleteButton = driver.findElement(By.cssSelector(departmentRowLocator+":nth-child(" + (index + 1) + ") .btn__close"));
        click(deleteButton);
    }
}
