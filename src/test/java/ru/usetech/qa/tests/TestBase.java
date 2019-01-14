package ru.usetech.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.usetech.qa.appmanager.ApplicationManager;

public class TestBase {

  private WebDriver driver;
  public ApplicationManager app;

  @BeforeClass
  public void start() {
    if  (driver !=null){
      return;
    }
    driver = new ChromeDriver();
    app = new ApplicationManager(driver);
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized");
    driver = new ChromeDriver(options);
  }

  @AfterClass
  public void stop(){
    driver.quit();
    driver=null;
  }

}
