package ru.usetech.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.model.ManIncData;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ManualIncPage extends Page {

  public ManualIncPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);

  }

  @FindBy(css = ".btn-big")
  private WebElement createBtn;

  @FindBy(css = "div.modal-footer > button.btn__blue")
  private WebElement saveBtn;

  @FindBy(css = "input.ng-invalid")
  private WebElement postUrl;

  @FindBy(css = ".textarea")
  private WebElement postText;

  @FindBy(css = ".modal-dialog")
  private WebElement modalDialog;

  /*@FindBy(css = "label.ng-tns-c0-8")
  private WebElement locationSelector;*/

  public void initManIncPage() {
    wait.until(ExpectedConditions.elementToBeClickable(createBtn));
    click(createBtn);
    wait.until(visibilityOf(modalDialog));

  }

  public void fillmanIncData(ManIncData manIncData) {

    type(postUrl, manIncData.getPostUrlField());
    type(postText, manIncData.getPostText());
  }

  public void clickSave() {
    wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
    click(saveBtn);
  }

  public void isManIncPageClosed(){
      wait.until(ExpectedConditions.visibilityOf(modalDialog));
  }


}





