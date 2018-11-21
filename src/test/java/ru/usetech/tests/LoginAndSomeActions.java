package ru.usetech.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginAndSomeActions {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://mlgext.usetech.ru/#/login");
    }

    @Test
    private void LoginToIM() throws Exception {
        login();
        settingsButtonPress();
        createManualIncButtonPress();

    }

    private void createManualIncButtonPress() {
        WebElement createIncButton = driver.findElement(By.cssSelector(".btn-big"));
        Actions actionbtn = new Actions(driver);
        actionbtn.moveToElement(createIncButton).contextClick();
        driver.findElement(By.cssSelector(".btn-big")).click();

        /*WebElement closeButtonIcon = driver.findElement(By.cssSelector(".fa-times"));
        Actions actionCloseBtn = new Actions(driver);
        actionCloseBtn.moveToElement(closeButtonIcon).click().build().perform();*/

    /*    driver.findElement(By.cssSelector(".fa-times")).isDisplayed();
        driver.findElement(By.cssSelector(".fa-times")).click();*/
    }

    private void settingsButtonPress() {
        WebElement settingsButton = driver.findElement(By.cssSelector("a.left-menu__link[href*='settings']"));
        Actions action = new Actions(driver);
        action.moveToElement(settingsButton).contextClick();

    }


    private void login() {
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("vm_user02@mail.ru");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузка параметров'])[1]/preceding::button[1]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }


}

