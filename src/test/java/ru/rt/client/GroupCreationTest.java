package ru.rt.client;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testAddGroup() throws Exception {
        navToGroupPage();
        initAddGroup();
        fillGroupForm(new GroupData("Group name", "header test", "footer test"));
        submitAddGroup();
    }

}
