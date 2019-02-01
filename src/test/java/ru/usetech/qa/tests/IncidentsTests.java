package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

public class IncidentsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {

        app.goTo().posts();

    }

    @Test
    public void createManualIncdent() {
        app.manualInc().add();
        app.manualInc().fill(new ManIncData().postText("#Random text").postUrlField("https://www.google.com/search/1"));
        app.manualInc().save();

        app.manualInc().alertSuccess();

    }

}
