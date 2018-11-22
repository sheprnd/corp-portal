package ru.usetech.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ManualIncCreationTest {

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
    private void testBody() throws Exception {
        login();
        TimeUnit.SECONDS.sleep(5);
        openModal();
        TimeUnit.SECONDS.sleep(5);
        enterAnswerText();
        TimeUnit.SECONDS.sleep(5);
        enterPostUrl();
        TimeUnit.SECONDS.sleep(5);
        selectLocation();
        TimeUnit.SECONDS.sleep(5);
        pressCreateBtn();

    }

    private void pressCreateBtn() {
        driver.findElement(By.cssSelector("div.modal-footer > button.btn__blue")).click();
    }

    private void selectLocation() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500);");

        WebElement locationSelectorOpen = driver.findElement(By.cssSelector("label.ng-tns-c0-8"));
        locationSelectorOpen.click();

        WebElement searchField = driver.findElement(By.cssSelector("ul.ui-dropdown-items"));
        searchField.click();
        System.out.println("Location has been added");
    }

    private void enterPostUrl() {
        driver.findElement(By.cssSelector(".textarea")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".textarea")).sendKeys("Текст ответа такой-то");
        System.out.println("Answer text has been inputed");
    }

    private void enterAnswerText() {
        long suffix = System.currentTimeMillis() / 1000L;
        driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("input.ng-invalid")).sendKeys("http://dwarfpool.com/xmr/" + suffix);
        System.out.println("Post url has been added");

    }


    private void openModal() throws InterruptedException {
        if (driver.findElement(By.cssSelector(".btn-big")).isDisplayed()) {
            driver.findElement(By.cssSelector(".btn-big")).sendKeys(Keys.RETURN);
            System.out.println("Modal opened");

        } else {
            System.out.println("Modal has not been opened");
        }


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
