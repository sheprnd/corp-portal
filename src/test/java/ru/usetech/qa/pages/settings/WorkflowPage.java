package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WorkflowPage extends Page {

    public WorkflowPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".content__filtr .btn")
    private WebElement saveWorkflowButton;

    @FindBy(css = ".add-pep__line_general-settings")
    private WebElement generalSettings;

    public void activateStage(int index) {

        List<WebElement> stages = driver.findElements(By.cssSelector(".settings-pipe"));
        WebElement stage = stages.get(index);
        stage.findElement(By.cssSelector(".switch__slider")).click();
        save();

    }

    public void save() {
        click(saveWorkflowButton);
        closeAlert();
        wait.until(visibilityOf(generalSettings));

    }
}
