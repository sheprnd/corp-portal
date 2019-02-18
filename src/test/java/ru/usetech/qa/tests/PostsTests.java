package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.testng.Assert.assertTrue;

public class PostsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {

        app.goTo().pipeline();

    }

    @Test(priority = 1)
    public void movePostToSelected() {

        if (!app.pipeline().isStageSelectedActive()) {
            app.goTo().settings();
            app.settings().goToWorkflow();
            app.workflow().activateStage(2);
            app.goTo().pipeline();
        }

        app.posts().moveToSelected();
        assertTrue(app.posts().alertSuccess());

    }

    @Test(priority = 2)
    public void movePostToDeleted() throws IOException, URISyntaxException {

        app.posts().moveToDeleted();

        if (app.session().getActiveDeleteReasons() > 2) {
            app.posts().setupDeleteReason();
         }

        assertTrue(app.posts().alertSuccess());

    }



}
