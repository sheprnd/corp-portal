package ru.usetech.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

public class IncidentsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().posts();
        app.goToStage().goToIncidents();

    }

    @Test(priority = 1/*, invocationCount = 5*/)
    public void createManualIncdent() {

        app.manualInc().add();
        app.manualInc().fill(new ManIncData().postText("#Random text").postUrlField("https://www.google.com/search/1"));
        app.manualInc().save();
        app.manualInc().alertSuccess();

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

}
