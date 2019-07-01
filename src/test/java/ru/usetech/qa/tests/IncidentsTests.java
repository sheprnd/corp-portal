package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

import java.util.Random;

import static org.testng.Assert.assertTrue;

public class IncidentsTests extends TestBase {

    /*@BeforeTest
    public void ensurePreconditions() {
        app.goTo().pipeline();
        app.pipeline().goToIncidents();

    }

    @DataProvider(name = "incidentData")
    public static Object[][] incidentDataProvider() {
        return new Object[][]{
                {"#Random text 1", "https://vk.com/wall423822898", "https://vk.com/wall423822898_532"},
                {"#Random text 2", "https://vk.com/wall423822898", "https://vk.com/wall423822898_530"}
        };
    }


    @Test(priority = 1, dataProvider = "incidentData")
    public void createManualIncident(String text, String blog, String url) {

        app.manualInc().add(new ManIncData().postText(text).postBlog(blog).postUrlField(url));
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

    @DataProvider(name = "pubIncData")
    public static Object[][] pubIncDataProvider() {
        return new Object[][]{
                {new Random()
                        .nextInt(100000) + "Valued" + String.valueOf(new Random().nextInt(10000)),
                        "https://vk.com/wall423822898",
                        "https://vk.com/wall423822898_530"}};
    }

    @Test(priority = 5, dataProvider = "pubIncData")
    public void publication(String text, String blog, String url) {


        app.manualInc().add(new ManIncData()
                .postText(String.valueOf(text))
                .postBlog(blog)
                .postUrlField(url));

        app.incidents().searchIncident(text);
        app.incidents().openIncident();
        app.incidents().publish("Ответ " + new Random().nextInt(10000));
        assertTrue(app.incidents().isPublicationSuccess(), "Неуспешная публикация");
        app.incidents().closeIncident();



    }*/

}
