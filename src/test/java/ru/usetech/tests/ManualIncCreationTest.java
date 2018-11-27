package ru.usetech.tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ManualIncCreationTest extends TestBase {


    @Test
    private void testBody() throws Exception {
        login("vm_user02@mail.ru", "12345");
        TimeUnit.SECONDS.sleep(2);
        openModal();
        TimeUnit.SECONDS.sleep(2);
        enterPostUrl(new EnterPostUrl("http://dwarfpool.com/xmr/"));
        TimeUnit.SECONDS.sleep(2);
        enterAnswerContent("Текст ответа такой-то");
        TimeUnit.SECONDS.sleep(2);
        selectLocation();
        TimeUnit.SECONDS.sleep(2);
        TimeUnit.SECONDS.sleep(2);
        pressCreateBtn();


    }


}
