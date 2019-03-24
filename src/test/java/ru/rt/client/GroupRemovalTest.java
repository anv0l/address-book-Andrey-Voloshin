package ru.rt.client;

import org.testng.annotations.Test;

public class GroupRemovalTest extends TestBase {

    @Test
    public void testGroupRemoval() throws Exception {
        navToGroupPage();
        selectGroup();
        deleteSelectedGroup();
    }

}
