package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.usetech.qa.model.SocialAccountData;
import ru.usetech.qa.pages.Page;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class VKSocialAccountPage extends Page {

    public VKSocialAccountPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".dd-btn")
    private WebElement addButton;

    @FindBy(css = ".dd-btn-list > li:first-child")
    private WebElement VKButton;

    @FindBy(css = "social-modal")
    private WebElement modalForm;

    @FindBy(css = "[formcontrolname=username]")
    private WebElement username;

    @FindBy(css = "[formcontrolname=password]")
    private WebElement password;

    @FindBy(css = ".modal-footer [type=submit]")
    private WebElement submitButton;

    @FindBy(css = ".social__modal-groups")
    private WebElement socialGroupsModalForm;

    @FindBy(css = "select-acc-groups-modal .btn")
    private WebElement continueButton;

    @FindBy(css = "social-modal .btn")
    private WebElement OKButton;

    private void initVKSocialAccountCreation() {
        click(addButton);
        click(VKButton);
        wait.until(visibilityOf(modalForm));
    }

    private void fillVKSocialAccountForm(SocialAccountData socialAccountData) {

        type(username, socialAccountData.getUsername());
        type(password, socialAccountData.getPassword());

    }

    private void submitVKSocialAccount() {
        click(submitButton);
    }

    private void selectVKGroups(String[] groups) {

        WebDriverWait w = new WebDriverWait(driver, 30);
        w.until(visibilityOf(socialGroupsModalForm));

        // список групп учетки в окне выбора групп
        List<WebElement> accGroups = driver.findElements(By.cssSelector(".social__modal-groups > div.ng-star-inserted label"));

        for (String group:groups) {

            WebElement groupItem = accGroups.stream().filter((m) -> m.getText().equals(group)).findFirst().get();
            click(groupItem);
        }
    }

    public void create(SocialAccountData socialAccountData) {

        initVKSocialAccountCreation();
        fillVKSocialAccountForm(socialAccountData);
        submitVKSocialAccount();

        if (socialAccountData.isWithGroups()) {
            selectVKGroups(socialAccountData.getGroups());
            click(continueButton);
        }

        click(OKButton);

    }

    public boolean success() {

        if (isElementPresent(OKButton)){
            click(OKButton);
            return true;
        }
        else { return false; }

    }
}
