package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class IncidentsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {
        app.goTo().pipeline();
        app.pipeline().goToIncidents();

    }

    /*
    <<<<<<< HEAD
        @Test(priority = 1, invocationCount = 1)
        public void createManualIncdent() {
            app.manualInc().add();
            app.manualInc().fill(new ManIncData().text("#Random text").blog("https://www.google.com/search/1"));
    =======
    */
    @DataProvider(name = "incidentData")
    public static Object[][] incidentDataProvider() {
        return new Object[][]{
                {"#Random text 1", "https://www.google.com/search/1"},
                {"#Random text 2", "https://www.google.com/search/2"}
        };
    }

    @Test(priority = 1, dataProvider = "incidentData")
    public void createManualIncident(String text, String url) {

        app.manualInc().add();
        app.manualInc().fill(new ManIncData().postText(text).postUrlField(url));
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
    public void moveIncToOtherStage() {

        app.incidents().openIncident();
        app.incidents().moveIncident();
        assertTrue(app.incidents().alertSuccess());

    }

    @Test(priority = 5)
    public void publication() {
        String randomText = "Value #" + String.valueOf(new Random().nextInt(10000));
        String searchText = randomText;
        app.manualInc().add();
        app.manualInc()
                .fill(new ManIncData().text(randomText).blog("https://vk.com/wall423822898")
                        .url("https://vk.com/wall423822898_530"));
        app.manualInc().save();
        app.manualInc().alertSuccess();
        app.incidents().publish(searchText);

        app.pipeline().goToPosts();
        app.pipeline().goToIncidents();

        app.incidents().isPubSuccess(searchText);


    }

}
