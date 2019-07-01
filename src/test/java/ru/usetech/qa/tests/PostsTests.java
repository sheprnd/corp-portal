package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PostsTests extends TestBase {
/*
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
    public void movePostToDeleted() throws Exception {

        app.posts().moveToDeleted();

        if (app.postsHelper().areSimilarPostsExists(app.posts().getId())) {
            app.posts().deleteCurrent();
        }

        if (app.settingsHelper().getActiveDeleteReasons() > 2) {
            app.deleteReasonDialog().setupReason();
         }

        assertTrue(app.posts().alertSuccess());

    }

*/

}
