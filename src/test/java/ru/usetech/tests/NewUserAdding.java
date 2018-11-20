package ru.usetech.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.name;
import static org.testng.Assert.assertTrue;


public class NewUserAdding {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://mlgext.usetech.ru/#/login");
    }

    @Test
    private void Actions() throws Exception {

        login();

        driver .findElement(By.cssSelector("a.left-menu__link[href*='#/settings]::after")).click();
       /* driver.findElement(By.cssSelector("button[textContent=Добавить][type='button']")).click();
        driver.findElement(By.cssSelector("input[placeholder=Введите фамилию][type='text']")).click();
        driver.findElement(By.cssSelector("input[name='lastName'][type='text']")).sendKeys("Last");*/


        /*driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys("Last");
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys("First" );
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("1@mail.ru");
        driver.findElement(By.name("pass1")).click();
        driver.findElement(By.name("pass1")).clear();
        driver.findElement(By.name("pass1")).sendKeys("1");
        driver.findElement(By.name("pass2")).click();
        driver.findElement(By.name("pass2")).clear();
        driver.findElement(By.name("pass2")).sendKeys("1");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Админ без прав'])[1]/following::div[4]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите файл'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Выход")).click();*/
    }

    private void goToUsers() {

        driver.navigate().to("mlgext.usetech.ru/#/settings/users");
    }

    private void login() {
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("vm_user04@mail.ru");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузка параметров'])[1]/preceding::button[1]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }


}

