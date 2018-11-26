package ru.usetech.tests;

import org.testng.annotations.Test;

public class ManualIncCreationTest extends TestBase {


    @Test
    private void testBody() throws Exception {
        login("vm_user02@mail.ru", "12345");
        openModal();
        enterPostUrl(new EnterPostUrl("http://dwarfpool.com/xmr/"));
        enterAnswerContent("Текст ответа такой-то");
        selectLocation();
        pressCreateBtn();

    }


}
