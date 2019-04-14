package ru.rt.client.tests;

import org.testng.annotations.Test;

public class GroupRemovalTest extends TestBase {

    @Test
    public void testGroupRemoval() throws Exception {
        app.getNavigationHelper().navToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
    }

}
