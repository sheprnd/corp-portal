package ru.usetech.qa.tests;

import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

public class IncidentsTests extends TestBase {

    @Test public void createManualIncdent() {
        app.openManualincPage().initManIncPage();
        app.openManualincPage().fillmanIncData(new ManIncData().postText("#Random text").postUrlField("#Random url text"));
        app.openManualincPage().clickSave();
    }

}
