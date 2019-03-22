package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.CategoryData;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CategoryPage extends Page {

    public CategoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".content__header .btn")
    private WebElement addButton;

    @FindBy(css = ".modal-body")
    private WebElement modalForm;

    @FindBy(css = "input[formcontrolname='name']")
    private WebElement name;

    @FindBy(css = ".modal-footer .btn.btn-left.btn__blue")
    private WebElement saveButton;

    private void initCategoryCreation() {
        click(addButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillCategoryForm(CategoryData categoryData) {

        type(name, categoryData.getCategoryName());
    }

    private void saveCategory() {
        click(saveButton);
    }

    public void create(CategoryData categoryData) {
        initCategoryCreation();
        fillCategoryForm(categoryData);
        saveCategory();

    }
}
