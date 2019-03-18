package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

import static org.testng.Assert.assertTrue;

public class IncidentsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().pipeline();
        app.pipeline().goToIncidents();

    }

    @Test(priority = 1)
    public void createManualIncident() {

        app.manualInc().add();
        app.manualInc().fill(new ManIncData().postText("#Random text").postUrlField("https://www.google.com/search/1"));
        app.manualInc().save();
        assertTrue(app.manualInc().alertSuccess());

    }

    @Test(priority = 2)
    public void deleteIncFromList() throws Exception {

        app.incidents().deleteIncident(true);

        if (app.settingsHelper().getActiveDeleteReasons() > 2) {
            app.deleteReasonDialog().setupReason();
        }

        assertTrue(app.incidents().alertSuccess());
    }

    @Test(priority = 3)
    public void deleteIncFromModal() throws Exception {

        app.incidents().openIncident();
        app.incidents().deleteIncident(false);

        if (app.settingsHelper().getActiveDeleteReasons() > 2) {
            app.deleteReasonDialog().setupReason();
        }

        assertTrue(app.incidents().alertSuccess());

    }

    @Test(priority = 4)
    public void moveIncToOtherStage(){

        app.incidents().openIncident();
        app.incidents().moveIncident();
        assertTrue(app.incidents().alertSuccess());

    }

/*
    @Test(priority = 5, invocationCount = 500 )
    public void publicationToOk(){

        app.incListPage().publishToOk();



    }
*/

}
