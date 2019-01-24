package ru.usetech.qa.tests;

import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

public class IncidentsTests extends TestBase {

    @Test
    public void createManualIncdent() {
        app.openManualincPage().initManIncPage();
        app.openManualincPage().fillmanIncData(new ManIncData().postText("#Random text").postUrlField("https://www.google.com/search/1"));
        app.openManualincPage().clickSave();
        app.openManualincPage().isManIncPageClosed();
        app.openManualincPage().alertSuccess();

    }

}
