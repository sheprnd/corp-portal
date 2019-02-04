package ru.usetech.qa.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.usetech.qa.model.ManIncData;

public class PostsTests extends TestBase {

    @BeforeTest
    public void ensurePreconditions() {

        app.goTo().posts();

    }

    @Test(priority = 1)
    public void movePostToSelected() {

        app.postsPage().moveToSelected();
        app.postsPage().alertSuccess();

    }

    @Test(priority = 2)
    public void movePostToDeleted() {

        app.postsPage().moveToDeleted();
        app.postsPage().alertSuccess();

    }

}
