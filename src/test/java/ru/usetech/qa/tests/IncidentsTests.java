package ru.usetech.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

import static org.testng.Assert.assertTrue;

public class IncidentsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().pipeline();
        app.pipeline().goToIncidents();

    }

    @Test(priority = 1)
    public void createManualIncdent() {

        app.manualInc().add();
        app.manualInc().fill(new ManIncData().postText("#Random text").postUrlField("https://www.google.com/search/1"));
        app.manualInc().save();
        assertTrue(app.posts().alertSuccess());

    }

    @Test(priority = 2)
    public void deleteIncFromList(){

        app.incListPage().deleteIncFromList();

    }

    @Test(priority = 3)
    public void deleteIncFromModal(){

        app.incListPage().deleteIncFromModal();

    }

    @Test(priority = 4)
    public void moveIncToOtherStage(){

        app.incListPage().moveToOtherStage();

    }

/*
    @Test(priority = 5, invocationCount = 500 )
    public void publicationToOk(){

        app.incListPage().publishToOk();



    }
*/

}
