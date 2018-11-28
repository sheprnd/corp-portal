package ru.usetech.qa.tests;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
public class ManualIncCreationTest extends TestBase {

  @Test
  private void testBody() throws Exception {
    app.login("vm_user02@mail.ru", "12345");
    TimeUnit.SECONDS.sleep(2);
    app.getNavigationHelper().openModal();
    TimeUnit.SECONDS.sleep(2);
    app.enterPostUrl("http://dwarfpool.com/xmr/");
    TimeUnit.SECONDS.sleep(2);
    app.enterAnswerContent("Текст ответа такой-то");
    TimeUnit.SECONDS.sleep(2);
    app.selectLocation();
    TimeUnit.SECONDS.sleep(2);
    app.getNavigationHelper().pressCreateBtn();


  }


}
