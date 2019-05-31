package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.model.FeedbackTemplateData;
import ru.usetech.qa.pages.Page;

import java.util.ArrayList;
import java.util.List;

public class FeedbackTemplatesList extends Page {

    private final String feedbackTemplateRowLocator = ".categories div.table__line";

    public FeedbackTemplatesList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int count() {
        return getFeedbackTemplates().size();
    }

    public void waitListUpdated(int count, int operationType) {
        waitListUpdated(feedbackTemplateRowLocator, count, operationType);
    }

    private List<WebElement> getFeedbackTemplates(){
        return driver.findElements(By.cssSelector(feedbackTemplateRowLocator));
    }

    public List<FeedbackTemplateData> getList() {
        List<FeedbackTemplateData> feedbackTemplates = new ArrayList<>();
        getFeedbackTemplates().forEach((m) -> feedbackTemplates.add(getFeedbackTemplateFromRow(m)));
        return feedbackTemplates;
    }

    private FeedbackTemplateData getFeedbackTemplateFromRow(WebElement feedbackTemplateRow) {
        return new FeedbackTemplateData().withName(feedbackTemplateRow.getText());
    }

    public void delete(int index) {
        WebElement deleteButton = driver.findElement(By.cssSelector(feedbackTemplateRowLocator+":nth-child(" + (index + 1) + ") .btn__close"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,"+(deleteButton.getLocation().getY()-700)+");");
        click(deleteButton);
    }

    public int getNotDefaultFeedbackTemplateIndex() {
        List<WebElement> templates = getFeedbackTemplates();
        for (int i=0;i<templates.size();i++) {
            if (!templates.get(i).getText().contains("По умолчанию"))
                return i+1;
        }
        return -1;
    }

    public boolean isDefaultFeedbackTemplate(int index) {
       return  getFeedbackTemplates().get(index-1).getText().contains("По умолчанию");
    }
}
