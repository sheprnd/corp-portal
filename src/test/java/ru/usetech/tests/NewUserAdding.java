package ru.usetech.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NewUserAdding {
    private WebDriver driver;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    private void Actions() throws Exception {
        driver.get("https://mlgext.usetech.ru/#/login");
        driver.findElement(By.name("login")).clear();
        driver.findElement(By.name("login")).sendKeys("vm_user01@mail.ru");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Загрузка параметров'])[1]/preceding::button[1]")).click();
        /*driver.wait(5);
        driver.findElement(By.linkText("Пользователи")).click();
        driver.wait(5);
        driver.findElement(By.name("lastName")).click();
        driver.findElement(By.name("lastName")).clear();
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
        driver.wait(15);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Админ без прав'])[1]/following::div[4]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Выберите файл'])[1]/following::button[1]")).click();
        driver.findElement(By.linkText("Выход")).click();*/
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();

    }


}

