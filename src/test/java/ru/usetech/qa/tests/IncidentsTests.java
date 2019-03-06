package ru.usetech.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

import java.util.Random;

public class IncidentsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().pipeline();
        app.pipeline().goToIncidents();

    }

    @Test(priority = 1, invocationCount = 1)
    public void createManualIncdent() {
        app.manualInc().add();
        app.manualInc().fill(new ManIncData().text("#Random text").blog("https://www.google.com/search/1"));
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

    @Test(priority = 5 )
    public void publication(){
        String randomText = "Value #" + String.valueOf(new Random().nextInt(10000));
        String searchText = randomText;
        app.manualInc().add();
        app.manualInc()
                .fill(new ManIncData().text(randomText).blog("https://vk.com/wall423822898")
                .url("https://vk.com/wall423822898_530"));
        app.manualInc().save();
        app.manualInc().alertSuccess();
        app.incListPage().publish(searchText);

        app.pipeline().goToPosts();
        app.pipeline().goToIncidents();

        app.incListPage().isPubSuccess(searchText);



    }

}
